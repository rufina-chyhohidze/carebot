package be.kdg.programming3.domain;

import jakarta.persistence.*;

import java.time.Duration;
import java.time.LocalDateTime;

@Entity
@Table(name = "DELIVERIES")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deliveryId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_request_id", referencedColumnName = "id")
    private ItemRequest itemRequest;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    private LocalDateTime deliveryStarted;

    private LocalDateTime deliveryFinished;

    private Long totalDeliveryTime;

    @Column(name = "number_of_obstacles")
    private int numberOfObstacles;

    public int getNumberOfObstacles() {
        return numberOfObstacles;
    }

    protected Delivery() {} // JPA requires a no-arg constructor

    public Delivery(ItemRequest itemRequest, LocalDateTime deliveryStarted, DeliveryStatus status) {
        this.status = status;
        this.deliveryStarted = deliveryStarted;
        this.itemRequest = itemRequest;
    }

    public int getDeliveryId() { return deliveryId; }
    public ItemRequest getItemRequest() { return itemRequest; }
    public void setItemRequest(ItemRequest itemRequest) { this.itemRequest = itemRequest; }
    public DeliveryStatus getStatus() { return status; }
    public void setStatus(DeliveryStatus status) { this.status = status; }
    public LocalDateTime getDeliveryStarted() { return deliveryStarted; }
    public LocalDateTime getDeliveryFinished() { return deliveryFinished; }
    public void setDeliveryFinished(LocalDateTime deliveryFinished) {
        this.deliveryFinished = deliveryFinished;
        this.totalDeliveryTime = Duration.between(deliveryStarted, deliveryFinished).toSeconds();
    }
    public Long getTotalDeliveryTime() { return totalDeliveryTime; }

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

}
