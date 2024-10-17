package be.kdg.programming3.domain;

import java.sql.Timestamp;
import java.util.List;

public class Delivery {
    private int deliveryId;
    private int employeeId;
    private List<ItemRequest> itemRequests;
    private Timestamp deliveryTime;

    public Delivery(int deliveryId, int employeeId, List<ItemRequest> itemRequests, Timestamp deliveryTime) {
        this.deliveryId = deliveryId;
        this.employeeId = employeeId;
        this.itemRequests = itemRequests;
        this.deliveryTime = deliveryTime;
    }

    public Delivery(int deliveryId, int employeeId, Timestamp deliveryTime) {
        this.deliveryId = deliveryId;
        this.employeeId = employeeId;
        this.deliveryTime = deliveryTime;
    }

    public int getDeliveryId() {return deliveryId;}
    public void setDeliveryId(int deliveryId) {this.deliveryId = deliveryId;}

    public int getEmployeeId() {return employeeId;}
    public void setEmployeeId(int employeeId) {this.employeeId = employeeId;}

    public List<ItemRequest> getItemRequests() {return itemRequests;}
    public void setItemRequests(List<ItemRequest> itemRequests) {this.itemRequests = itemRequests;}

    public Timestamp getDeliveryTime() {return deliveryTime;}
    public void setDeliveryTime(Timestamp deliveryTime) {this.deliveryTime = deliveryTime;}

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", employeeId=" + employeeId +
                ", itemRequests=" + itemRequests +
                ", deliveryTime=" + deliveryTime +
                '}';
    }
}
