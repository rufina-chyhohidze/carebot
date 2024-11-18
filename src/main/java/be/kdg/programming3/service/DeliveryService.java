package be.kdg.programming3.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import be.kdg.programming3.domain.Delivery;

public interface DeliveryService {
    List<Delivery> getAllDeliveries();
    Delivery getDeliveryById(int deliveryId);
    void addDelivery(Delivery delivery);
    void updateDelivery(int deliveryId, LocalDateTime deliveryFinished);

}
