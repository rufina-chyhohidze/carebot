package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, Integer> {

//    Delivery createDelivery(Delivery delivery);
//    Delivery findDeliveryByDeliveryId(int id);
//    List<List<String>> findAllDeliveries();

}
