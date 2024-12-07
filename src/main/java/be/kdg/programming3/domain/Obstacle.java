//package be.kdg.programming3.domain;
//
//import jakarta.persistence.*;
//
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "obstacle_table")
//public class Obstacle {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long obstacleId;
//
//    @ManyToOne
//    @JoinColumn(name = "delivery_id")
//    private Delivery delivery;
//
//    @Column(name = "obstacle_timestamp_before")
//    private LocalDateTime obstacleTimestampBefore; //when found an obstacle
//
//    @Column(name = "obstacle_timestamp_after")
//    private LocalDateTime obstacleTimestampAfter; //when started driving again
//
//    public Obstacle() {}
//
//    public Obstacle(Long obstacleId, Delivery delivery, LocalDateTime obstacleTimestampBefore, LocalDateTime obstacleTimestampAfter) {
//        this.obstacleId = obstacleId;
//        this.delivery = delivery;
//        this.obstacleTimestampBefore = obstacleTimestampBefore;
//        this.obstacleTimestampAfter = obstacleTimestampAfter;
//    }
//
//    public Long getObstacleId() {return obstacleId;}
//    public void setObstacleId(Long obstacleId) {this.obstacleId = obstacleId;}
//    public Delivery getDelivery() {return delivery;}
//    public void setDelivery(Delivery delivery) {this.delivery = delivery;}
//    public LocalDateTime getObstacleTimestampBefore() {return obstacleTimestampBefore;}
//    public void setObstacleTimestampBefore(LocalDateTime obstacleTimestampBefore) {this.obstacleTimestampBefore = obstacleTimestampBefore;}
//    public LocalDateTime getObstacleTimestampAfter() {return obstacleTimestampAfter;}
//    public void setObstacleTimestampAfter(LocalDateTime obstacleTimestampAfter) {this.obstacleTimestampAfter = obstacleTimestampAfter;}
//
//    @Override
//    public String toString() {
//        return "Obstacle{" +
//                "obstacleId=" + obstacleId +
//                ", delivery=" + delivery +
//                ", obstacleTimestampBefore=" + obstacleTimestampBefore +
//                ", obstacleTimestampAfter=" + obstacleTimestampAfter +
//                '}';
//    }
//}
