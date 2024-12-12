import joblib
import pandas as pd


def make_prediction():
    # Load the trained model
    model = joblib.load('src/main/resources/static/python/best_model.pkl')

    # Create 3 hardcoded test cases
    test_data = pd.DataFrame({
        'hour': [8, 15, 20],  # Hour of delivery
        'day_of_week': [1, 3, 5],  # Days of week (0=Monday, 6=Sunday)
        'month': [12, 5, 10],  # Months
        'number_of_obstacles': [1, 3, 22]  # Obstacles encountered
    })

    # Perform prediction with the trained model
    predictions = model.predict(test_data)

    # Return predictions
    for i, prediction in enumerate(predictions):
        row = test_data.iloc[i]
        print(
            f"Prediction {i+1}:\n"
            f"Hour = {row['hour']}, "
            f"Day of Week = {row['day_of_week']}, "
            f"Month = {row['month']}, "
            f"Obstacles = {row['number_of_obstacles']}\n"
            f"Predicted Delivery Time = {prediction[0]:.2f} minutes\n"
        )


if __name__ == "__main__":
    make_prediction()