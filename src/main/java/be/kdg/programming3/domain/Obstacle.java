package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "obstacle_table")
public class Obstacle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long obstacleId;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

//    private int deliveryId;
    @Column(name = "obstacle_timestamp")
    private Timestamp obstacle_timestamp;

    @Column(name = "obstacle_distance")
    private float obstacle_distance;

    public Obstacle() {}

//    public Obstacle() {
//        this.obstacleTimestamp = new Timestamp(System.currentTimeMillis());
//    }

    public Obstacle(float obstacle_distance) {
        this();
        this.obstacle_distance = obstacle_distance;
    }
//    public Obstacle(int deliveryId, int obstacleDistance) {
//        this();
//        this.deliveryId = deliveryId;
//        this.obstacleDistance = obstacleDistance;
//    }

    public Long getObstacleId() {return obstacleId;}
    public void setObstacleId(Long obstacleId) {this.obstacleId = obstacleId;}
//    public int getDeliveryId() {return deliveryId;}
//    public void setDeliveryId(int deliveryId) {this.deliveryId = deliveryId;}


    public Timestamp getObstacle_timestamp() {return obstacle_timestamp;}
    public void setObstacle_timestamp(Timestamp obstacle_timestamp) {this.obstacle_timestamp = obstacle_timestamp;}
    public float getObstacle_distance() {return obstacle_distance;}
    public void setObstacle_distance(float obstacle_distance) {this.obstacle_distance = obstacle_distance;}

    @Override
    public String toString() {
        return "Obstacle{" +
                "obstacleId=" + obstacleId +
                ", obstacle_timestamp=" + obstacle_timestamp +
                ", obstacle_distance=" + obstacle_distance +
                '}';
    }
}
