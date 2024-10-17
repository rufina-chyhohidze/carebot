package be.kdg.programming3.service;

import be.kdg.programming3.domain.Delivery;

import java.sql.Timestamp;
import java.util.List;

public interface DeliveryService {
    void addDelivery(int deliveryId, int employeeId, Timestamp deliveryTime);

    List<Delivery> getAllDeliveries();
}
