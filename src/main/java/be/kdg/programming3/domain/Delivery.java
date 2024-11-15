package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "delivery_table")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    private int employeeId;
    private Timestamp deliveryTime;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Obstacle> obstacles;

//    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<ItemRequest> itemRequests;

    public Delivery() {} // JPA requires a no-arg constructor

    public Delivery(int deliveryId, int employeeId, Timestamp deliveryTime) {
        this.deliveryId = deliveryId;
        this.employeeId = employeeId;
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryId() {return deliveryId;}
    public void setDeliveryId(int deliveryId) {this.deliveryId = deliveryId;}

    public int getEmployeeId() {return employeeId;}
    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}

//    public List<ItemRequest> getItemRequests() {return itemRequests;}
//    public void setItemRequests(List<ItemRequest> itemRequests) {this.itemRequests = itemRequests;}


    public List<Obstacle> getObstacles() {return obstacles;}
    public void setObstacles(List<Obstacle> obstacles) {this.obstacles = obstacles;}

    public Timestamp getDeliveryTime() {return deliveryTime;}
    public void setDeliveryTime(Timestamp deliveryTime) {this.deliveryTime = deliveryTime;}

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", employeeId=" + employeeId +
                ", deliveryTime=" + deliveryTime +
                ", obstacles=" + obstacles +
                '}';
    }
}
