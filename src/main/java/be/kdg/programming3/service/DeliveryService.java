package be.kdg.programming3.service;

import java.time.LocalDateTime;
import java.util.List;
import be.kdg.programming3.domain.Delivery;

public interface DeliveryService {
    List<Delivery> getAllDeliveries();
    Delivery createDelivery(Delivery delivery);
    void setDeliveryInProcessStatusToFinished(LocalDateTime timeFinished);
    boolean noDeliveriesInProcess();
    List<Delivery> getPendingDelivery();
    Delivery getLastCompletedDelivery();
    void setNumberOfObstaclesOfLastDelivery(Integer obstacle);

}
