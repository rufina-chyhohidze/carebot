package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Delivery;
//import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository {

    Delivery createDelivery(Delivery delivery);
    Delivery findDeliveryByDeliveryId(int id);
    List<List<String>> findAllDeliveries();

}
