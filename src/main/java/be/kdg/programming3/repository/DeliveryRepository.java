package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface DeliveryRepository {
    List<Delivery> getAllDeliveries();
    Delivery createDelivery(Delivery delivery);
    Delivery getDeliveryById(int id);

    void setDeliveryInProcessStatusToFinished(LocalDateTime timeFinished);
}
