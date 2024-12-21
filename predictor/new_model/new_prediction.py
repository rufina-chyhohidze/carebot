import pandas as pd
import datetime
import joblib

# Load the trained model
model_path = "predictor/new_model/new_model.pkl"
best_model = joblib.load(model_path)

# Map day of week to names
day_of_week_map = {
    0: 'Monday',
    1: 'Tuesday',
    2: 'Wednesday',
    3: 'Thursday',
    4: 'Friday',
    5: 'Saturday',
    6: 'Sunday'
}

# Get today's date and time
now = datetime.datetime.now()

# Extract current hour, minute, and day of the week
current_hour = now.hour
current_minute = now.minute
current_day_of_week = now.weekday()  # Monday=0, Sunday=6

# Generate dynamic test data for prediction
paths = ['Path 1', 'Path 2', 'Path 3']  # Paths as in training
number_of_obstacles = [5, 5, 5]  # Hypothetical obstacle counts for each path

# Create a test DataFrame
new_data = pd.DataFrame({
    'hour': [current_hour] * len(paths),
    'minute': [current_minute] * len(paths),
    'day_of_week': [current_day_of_week] * len(paths),
    'path': paths,
    'number_of_obstacles': number_of_obstacles
})

# Predict using the trained model
predicted_times = best_model.predict(new_data)

# Display predictions in minutes and seconds
for i, row in new_data.iterrows():
    day_name = day_of_week_map[row['day_of_week']]
    total_seconds = predicted_times[i]
    print(
        f"Prediction for {row['path']}:\n"
        f"Current Time = {row['hour']}:{row['minute']:02d}, "
        f"Day of Week = {day_name}, "
        f"Obstacles = {row['number_of_obstacles']}\n"
        f"Predicted Delivery Time = {total_seconds} seconds\n"
    )