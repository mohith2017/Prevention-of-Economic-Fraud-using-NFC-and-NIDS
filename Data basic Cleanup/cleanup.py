
import numpy as np
import pandas as pd

file_path = "D:/DESKTOP/MSRIT/Final Year/8th sem/Project/Latest ML-IDS/Dataset/UNSW_NB15_training-set.csv"

df = pd.read_csv(file_path)

#To read the dataset columns' and datatypes info, uncomment this
#df.info()

#Indicates no null and infinite values, meaning no cleaning necessary
#name of columns in df is also clean
for columns in df.columns:
    print("Number of infinite values in ",columns," : ",df[df[columns] == np.inf][columns].count())
    print("Number of null values in ",columns," : ",df[df[columns].isnull()][columns].count())
