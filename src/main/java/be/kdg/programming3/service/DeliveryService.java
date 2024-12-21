package be.kdg.programming3.service;

import java.time.LocalDateTime;
import java.util.List;
import be.kdg.programming3.domain.Delivery;

public interface DeliveryService {
    List<Delivery> getAllDeliveries();
    Delivery createDelivery(Delivery delivery);
    Delivery getDeliveryById(int deliveryId);

    void setDeliveryInProcessStatusToFinished(LocalDateTime timeFinished);
    public boolean noDeliveriesInProcess();
    List<Delivery> getPendingDelivery();

    Delivery getLastCompletedDelivery();

    Delivery getLastDeliveryLogged();

    void setNumberOfObstaclesOfLastDelivery(Integer obstacle);
//    void addDelivery(Delivery delivery);
//    void updateDelivery(int deliveryId, LocalDateTime deliveryFinished);

}
