#Questions to be answered
# How many normal and attack records are contained in the dataset?
# How many records are contained per attack type?
# Is there a strong correlation between certain features?
# Which features show a correlation with the binary class of a record?


import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns
import glob
from scipy import stats
from scipy.stats import ks_2samp


file_path = "D:/DESKTOP/MSRIT/Final Year/8th sem/Project/Latest ML-IDS/Dataset/UNSW_NB15_training-set.csv"

df = pd.read_csv(file_path)

#Since - values are there in 'service' column, it can't be considered for classification
del df['service']

print(df.columns)

#Various type of attack records
print(df['attack_cat'].value_counts())


#Relation between various types of attacks versus normal records
f, ax = plt.subplots(figsize=(7, 5))
ax.tick_params(axis='x', labelsize=7, rotation=90)
sns.countplot(x='attack_cat', data=df, order = df['attack_cat'].value_counts().index, ax=ax)
plt.show()

#Percentage of attack versus normal records
print()
print(df['label'].value_counts(normalize=True) * 100)

#Number of different types of attacks
print()
print(df.groupby('attack_cat').agg({'label':'first', 'label':'count'}).rename_axis(None).sort_values('label', ascending=False))


print()
print("Feature correlation")
#To analyze the correlation between different features a heatmap is created based on the correlation matrix of the dataset.
#The heatmap shows strong correlations for a number of feature-pairs.

corr = df.drop(columns=['label', 'id']).corr()
print(corr.columns)

plt.figure(figsize=(25, 20))
sns.heatmap(corr, xticklabels=corr.columns, yticklabels=corr.columns, linewidths=.5, cmap=sns.diverging_palette(620, 10, as_cmap=True))
plt.show()


#To get absolute correlations and remove columns with values<0.8 correlation
labels_to_drop = set()

def get_abs_correlations(df, t):
    cols = df.columns.drop(['label', 'id', 'attack_cat', 'proto', 'state'])
    for i in range(0, df.shape[1]-5):
        for j in range(0, i+1):
            labels_to_drop.add((cols[i], cols[j]))

    c = corr.abs().unstack().drop(labels=labels_to_drop).sort_values(ascending=False)
    #print("Columns dropped:", labels_to_drop)
    return c[c > t]

print(get_abs_correlations(df, 0.8))
