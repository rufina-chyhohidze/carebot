package be.kdg.programming3.domain;

public class Obstacle {
    private int obstacleId;


    public Obstacle(int obstacleId) {
        this.obstacleId = obstacleId;
    }

    public int getObstacleId() {
        return obstacleId;
    }

    public void setObstacleId(int obstacleId) {
        this.obstacleId = obstacleId;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "obstacleId=" + obstacleId +
                '}';
    }
}
