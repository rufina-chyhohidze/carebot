import pandas as pd

data = pd.read_csv('laptop_and_tablets.csv')
print(data.head())


print(data['category'].head())
print(data['name'].head())
print(data['price'].head())
print(data['stock_quantity'].head())