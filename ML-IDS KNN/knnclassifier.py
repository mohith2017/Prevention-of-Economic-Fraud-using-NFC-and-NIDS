import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
# import glob
# import os
#import shap
#import scikitplot as skplt
#import eli5
# from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
# from sklearn.dummy import DummyClassifier
# from sklearn.linear_model import LogisticRegression
# from sklearn.ensemble import RandomForestClassifier
from sklearn.neighbors import KNeighborsClassifier
from sklearn.metrics import classification_report, precision_recall_curve, average_precision_score
#from catboost import CatBoostClassifier
#from catboost import Pool
#from eli5.sklearn import PermutationImportance
from scipy.stats import spearmanr
from scipy.cluster import hierarchy
from collections import defaultdict
from scipy.stats import ks_2samp
from scipy.stats import describe
# from imblearn.over_sampling import SMOTENC
from collections import Counter
import time
#from IPython.display import display


#Read the processed dataset
df = pd.read_csv("D:/DESKTOP/MSRIT/Final Year/8th sem/Project/Latest ML-IDS/Dataset/UNSW_NB15_training-set.csv")


#Splitting target(y) and predictor(x) variables
X = df.drop(columns=['attack_cat', 'label'])
y = df[['attack_cat', 'label']]

print()
print("---------------Feature Engineering-----------------")

#Variance based filtering
#None of the columns have std=0, so all features are retained.

stats = X.describe()
std = stats.loc['std']
print(std)
features_no_variance = std[std == 0.0].index
unrelated = pd.Series(features_no_variance).sort_values()

#Unrelated features: Transaction protocol, state and its dependent protocol, id & service
X = X.drop(columns=['proto', 'state', 'id', 'service'])

#Multicollinear features
#Features having a high correlation amongst each other are removed.


cluster_threshold = 1

corr = spearmanr(X).correlation
corr_linkage = hierarchy.ward(corr)

fig, (ax1, ax2) = plt.subplots(2, 1, figsize=(25, 40))

sns.heatmap(corr, xticklabels=X.columns, yticklabels=X.columns, linewidths=.5, cmap=sns.diverging_palette(620, 10, as_cmap=True), ax=ax1)

dendro = hierarchy.dendrogram(corr_linkage, labels=X.columns, ax=ax2, leaf_rotation=90)
dendro_idx = np.arange(0, len(dendro['ivl']))
ax2.plot([0, 1000], [cluster_threshold, cluster_threshold], ':r')
plt.show()


#Selecting features with high correlation according to the dendogram to remove.
cluster_ids = hierarchy.fcluster(corr_linkage, cluster_threshold, criterion='distance')
cluster_id_to_feature_ids = defaultdict(list)

for idx, cluster_id in enumerate(cluster_ids):
    cluster_id_to_feature_ids[cluster_id].append(idx)
selected_features = [v[0] for v in cluster_id_to_feature_ids.values()]

selected_features = X.columns[selected_features].tolist()

print()
print('Selected features:')
features_selected = pd.Series(selected_features)
print(features_selected)

#Now, using the selected features only as predictor variables
X= X[selected_features]
print()
print(f"Remaining amount of features: {len(X.columns)}")


#Checking the updated heatmap for correlation between features, observe no dark red between 2 features now
corr_updated = spearmanr(X).correlation
f, ax = plt.subplots(figsize=(25, 20))
ax.tick_params(axis='x', labelsize=7, rotation=90)
sns.heatmap(corr_updated, xticklabels=X.columns, yticklabels=X.columns, linewidths=.5, cmap=sns.diverging_palette(620, 10, as_cmap=True),ax=ax )
plt.show()


#print report method based on DummyClassifier
def print_report(ds_type, cls, X_vals, y_true, y_predict, plot_pr=False, plot_roc=False):
    print(f"Classification Report ({ds_type}):")
    print(classification_report(y_true, y_predict))
    print(f"Avg Precision Score: {average_precision_score(y_true, y_predict, average='weighted')}")

    if plot_roc:
        print(f"ROC AUC Score: {roc_auc_score(y_true, y_predict)}")
        sklearn.metrics.plot_roc(y_true, cls.predict_proba(X_vals))
        plt.show()

    if plot_pr:

        sklearn.metrics.plot_precision_recall(y_true, cls.predict_proba(X_vals))
        plt.show()

    print('\n')

#Metrics based on number of attack versus normal records in training Dataset
percentage_normal = len(y.label[y.label == 0]) / len(y.label)

print('Class occurences:')
print(y.label.value_counts())
print('Percentage of normal samples: %.4f' % percentage_normal)

#Clearly, it is skewed towards malicious records

#The main KNN classifier!
scaler = StandardScaler()
scaler.fit(X)
X_transform = scaler.transform(X)

for k in range(2, 21):
    start_time = time.time()

    cls_knn = KNeighborsClassifier(n_neighbors = k)
    cls_knn.fit(X_transform, y.label)

    print_report('Training', cls_knn, X_transform, y.label, cls_knn.predict(X_transform))
    end_time = time.time()
    print("Time taken for k = ",k," is %s seconds\n" % (end_time - start_time))
