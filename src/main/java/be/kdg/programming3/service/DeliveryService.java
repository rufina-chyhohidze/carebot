package be.kdg.programming3.service;

import java.sql.Timestamp;
import java.util.List;

public interface DeliveryService {
    List<List<String>> getAllDeliveries();

    void addDelivery(int deliveryId, int employeeId, Timestamp deliveryTime);

}
