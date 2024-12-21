# import pandas as pd
# import numpy as np
# import datetime
# from sklearn.ensemble import RandomForestRegressor
# from sklearn.compose import ColumnTransformer
# from sklearn.preprocessing import StandardScaler, OneHotEncoder
# from sklearn.pipeline import Pipeline
# from sklearn.model_selection import train_test_split
# from sklearn.metrics import mean_squared_error, mean_absolute_error, r2_score
#
# # Load the data
# df = pd.read_csv("../deliveries_with_paths.csv")
#
# # Convert datetime columns
# df['delivery_finished'] = pd.to_datetime(df['delivery_finished'])
# df['delivery_started'] = pd.to_datetime(df['delivery_started'])
#
# # Feature engineering
# df['hour'] = df['delivery_finished'].dt.hour
# df['minute'] = df['delivery_finished'].dt.minute
# df['day_of_week'] = df['delivery_finished'].dt.dayofweek
#
# # Calculate targets
# df['total_delivery_time'] = (df['delivery_finished'] - df['delivery_started']).dt.total_seconds()
#
# # Filter for completed deliveries
# df = df[df['status'] == 'COMPLETED']
#
# # Define features and targets
# X_obstacles = df[['hour', 'minute', 'day_of_week', 'path']]
# y_obstacles = df['number_of_obstacles']
#
# X_time = df[['hour', 'minute', 'day_of_week', 'path', 'number_of_obstacles']]
# y_time = df['total_delivery_time']
#
# # Split the data
# X_train_obs, X_test_obs, y_train_obs, y_test_obs = train_test_split(X_obstacles, y_obstacles, test_size=0.2, random_state=42)
# X_train_time, X_test_time, y_train_time, y_test_time = train_test_split(X_time, y_time, test_size=0.2, random_state=42)
#
# # Preprocessing for obstacles model
# preprocessor_obs = ColumnTransformer(transformers=[
#     ('num', StandardScaler(), ['hour', 'minute', 'day_of_week']),
#     ('cat', OneHotEncoder(handle_unknown='ignore'), ['path'])
# ])
#
# # Preprocessing for time model
# preprocessor_time = ColumnTransformer(transformers=[
#     ('num', StandardScaler(), ['hour', 'minute', 'day_of_week', 'number_of_obstacles']),
#     ('cat', OneHotEncoder(handle_unknown='ignore'), ['path'])
# ])
#
# # Model pipelines
# pipeline_obs = Pipeline(steps=[
#     ('preprocessor', preprocessor_obs),
#     ('model', RandomForestRegressor(random_state=42))
# ])
#
# pipeline_time = Pipeline(steps=[
#     ('preprocessor', preprocessor_time),
#     ('model', RandomForestRegressor(random_state=42))
# ])
#
# # Train obstacles model
# pipeline_obs.fit(X_train_obs, y_train_obs)
#
# # Predict obstacles for time model training
# X_train_time['number_of_obstacles'] = pipeline_obs.predict(X_train_obs)
# X_test_time['number_of_obstacles'] = pipeline_obs.predict(X_test_obs)
#
# # Train delivery time model
# pipeline_time.fit(X_train_time, y_train_time)
#
# # Map day of week to names
# day_of_week_map = {
#     0: 'Monday',
#     1: 'Tuesday',
#     2: 'Wednesday',
#     3: 'Thursday',
#     4: 'Friday',
#     5: 'Saturday',
#     6: 'Sunday'
# }
#
# # Get today's date and time
# now = datetime.datetime.now()
#
# # Extract current hour, minute, and day of the week
# current_hour = now.hour
# current_minute = now.minute
# current_day_of_week = now.weekday()  # Monday=0, Sunday=6
# day_name = day_of_week_map[current_day_of_week]
#
# # Generate new test data dynamically
# paths = ['Path 1', 'Path 2', 'Path 3']  # Example paths
# new_data = pd.DataFrame({
#     'hour': [current_hour] * len(paths),
#     'minute': [current_minute] * len(paths),
#     'day_of_week': [current_day_of_week] * len(paths),
#     'path': paths
# })
#
# # Predict obstacles
# new_data['number_of_obstacles'] = pipeline_obs.predict(new_data)
#
# # Predict delivery time
# predicted_delivery_time = pipeline_time.predict(new_data)
#
# # Display predictions
# for i, row in new_data.iterrows():
#     print(
#         f"Prediction {i + 1}:\n"
#         f"Current Time = {row['hour']}:{row['minute']:02d}, "
#         f"Day of Week = {day_name}, Path = {row['path']}\n"
#         f"Predicted Number of Obstacles = {row['number_of_obstacles']:.2f}\n"
#         f"Predicted Delivery Time = {predicted_delivery_time[i]:.2f} seconds\n"
#     )
