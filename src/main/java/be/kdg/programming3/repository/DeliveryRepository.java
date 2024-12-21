package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Delivery;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DeliveryRepository {
    List<Delivery> getAllDeliveries();
    Delivery createDelivery(Delivery delivery);
    Delivery getDeliveryById(int id);
    public boolean noDeliveriesInProcess();
    void setDeliveryInProcessStatusToFinished(LocalDateTime timeFinished);

    List<Delivery> getPendingDelivery();

    Delivery getLastCompletedDelivery();

    Delivery getLastDeliveryLogged();

    void setNumberOfObstaclesOfLastDelivery(int numberOfObstacles);
}
