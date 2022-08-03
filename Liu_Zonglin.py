import numpy as np # linear algebra
import pandas as pd # data processing, CSV file I/O (e.g. pd.read_csv)
import difflib
pd.set_option('display.max_columns', 500)
import seaborn as sn
import matplotlib.pyplot as plt
import plotly.graph_objects as go
from sklearn import preprocessing
import os

import palettable

df_2015 = pd.read_csv("/Users/rose/Desktop/archive/2015.csv")
df_2016 = pd.read_csv("/Users/rose/Desktop/archive/2016.csv")
df_2017 = pd.read_csv("/Users/rose/Desktop/archive/2017.csv")
df_2018 = pd.read_csv("/Users/rose/Desktop/archive/2018.csv")
df_2019 = pd.read_csv("/Users/rose/Desktop/archive/2019.csv")
df_2020 = pd.read_csv("/Users/rose/Desktop/archive/2020.csv")
df_2021 = pd.read_csv("/Users/rose/Desktop/archive/2021.csv")

corrMatrix = df_20201.corr()

fig,ax = plt.subplots(figsize=(12,12),dpi=100)
# sn.heatmap(corrMatrix.round(3),annot=True,vmax = 0.1,
#  #

#           annot_kws={'size':8,'weight':'normal', 'color':'#000000'},
#        )
sn.heatmap(corrMatrix.round(2), annot=True,cmap=color)
plt.title("Correlation Map")
plt.show()