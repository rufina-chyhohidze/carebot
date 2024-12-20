package be.kdg.programming3.config;

public class DeliveryDto {
    private int deliveryId;
    private String deliveryStarted;
    private String deliveryFinished;
    private int numberOfObstacles;
    private String path;

    // Constructor
    public DeliveryDto(int deliveryId, String deliveryStarted, String deliveryFinished, int numberOfObstacles, String path) {
        this.deliveryId = deliveryId;
        this.deliveryStarted = deliveryStarted;
        this.deliveryFinished = deliveryFinished;
        this.numberOfObstacles = numberOfObstacles;
        this.path = path;
    }

    // Getters and setters (optional if you use Lombok)
    public int getDeliveryId() {
        return deliveryId;
    }

    public String getDeliveryStarted() {
        return deliveryStarted;
    }

    public String getDeliveryFinished() {
        return deliveryFinished;
    }

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    public String getPath() {
        return path;
    }
}

