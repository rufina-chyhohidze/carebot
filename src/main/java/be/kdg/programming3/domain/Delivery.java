package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery_table")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_request_id", referencedColumnName = "id")
    private ItemRequest itemRequest;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Column(name = "delivery_started")
    private LocalDateTime deliveryStarted;

    @Column(name = "delivery_finished")
    private LocalDateTime deliveryFinished;

    @Column(name = "total_delivery_time")
    private Long totalDeliveryTime;

    protected Delivery() {} // JPA requires a no-arg constructor

    public Delivery(ItemRequest itemRequest, LocalDateTime deliveryStarted, DeliveryStatus status) {
        this.status = status;
        this.deliveryStarted = deliveryStarted;
        this.itemRequest = itemRequest;
    }

    public int getDeliveryId() { return deliveryId; }
    public void setDeliveryId(int deliveryId) { this.deliveryId = deliveryId; }
    public ItemRequest getItemRequest() { return itemRequest; }
    public void setItemRequest(ItemRequest itemRequest) { this.itemRequest = itemRequest; }
    public DeliveryStatus getStatus() { return status; }
    public void setStatus(DeliveryStatus status) { this.status = status; }
    public LocalDateTime getDeliveryStarted() { return deliveryStarted; }
    public void setDeliveryStarted(LocalDateTime deliveryStarted) { this.deliveryStarted = deliveryStarted; }
    public LocalDateTime getDeliveryFinished() { return deliveryFinished; }
    public void setDeliveryFinished(LocalDateTime deliveryFinished) {
        this.deliveryFinished = deliveryFinished;
        this.totalDeliveryTime = Duration.between(deliveryStarted, deliveryFinished).toSeconds();
    }
    public Long getTotalDeliveryTime() { return totalDeliveryTime; }
    public void setTotalDeliveryTime(Long totalDeliveryTime) { this.totalDeliveryTime = totalDeliveryTime; }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", status=" + status +
                ", deliveryStarted=" + deliveryStarted +
                ", deliveryFinished=" + deliveryFinished +
                ", totalDeliveryTime=" + totalDeliveryTime +
                ", itemRequest=" + (itemRequest != null ? itemRequest.getId() : "null") +
                '}';
    }

//    public void calculateTotalDeliveryTime() {
//        if (deliveryStarted != null && deliveryFinished != null) {
//            Duration duration = Duration.between(deliveryStarted, deliveryFinished);
//            this.totalDeliveryTime = (int) duration.toMinutes();
//        } else {
//            this.totalDeliveryTime = 0;
//        }
//    }
}
