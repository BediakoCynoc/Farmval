#import pandas as pd
import numpy as np
from sklearn.ensemble import RandomForestRegressor
from sklearn.linear_model import LinearRegression
from sklearn.svm import SVR
from sklearn import metrics
from sklearn import linear_model
from sklearn.linear_model import LogisticRegression
from sklearn.model_selection import train_test_split
import csv


def test(input1, input2, input3, input4, input5, input6):
    return input1 + input2 + input3 + input4 + input5 + input6

def getSoilYield(input1, input2, input3, input4, input5, input6):
    print("Testing here")
    dataset = pd.read_csv("india_ds.csv", encoding="utf-8")
    dataset = []
    with open('india_ds.csv') as csv_file:
        csv_reader = csv.reader(csv_file, delimiter = ",")
        dataset = [row for row in csv_reader][1:]

    print("Testing here after reading data")

    #X = dataset.iloc[:, 0:-1].values
    #y = dataset.iloc[:, -1].values
    X = dataset[:,0:-1]
    y = dataset[:,-1]

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=0)
    regressor = RandomForestRegressor(n_estimators=100, random_state=0)
    regressor.fit(X_train, y_train)

    #y_pred_train = regressor.predict(X_train)
    #y_pred_test = regressor.predict(X_test)

    test = [[int(input1), int(input2), int(input3), float(input4), float(input5), int(input6)]]
    y_test = regressor.predict(test)

    return y_test[0]

    # print('Mean Absolute Error:', metrics.mean_absolute_error(y_test, y_pred))
    # print('Mean Squared Error:', metrics.mean_squared_error(y_test, y_pred))
    # print('Root Mean Squared Traning Error :', np.sqrt(metrics.mean_squared_error(y_train, y_pred_train)))
    # print('Root Mean Squared Testing Error :', np.sqrt(metrics.mean_squared_error(y_test, y_pred_test)))

