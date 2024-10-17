package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StaticListDeliveryRepository implements DeliveryRepository {
    private Logger LOG = LoggerFactory.getLogger(StaticListDeliveryRepository.class);
    private static List<Delivery> deliveries = new ArrayList<>();

    @Override
    public Delivery createDelivery(Delivery delivery) {
        LOG.info("Creating new delivery {}", delivery);
        deliveries.add(delivery);
        delivery.setDeliveryId(deliveries.indexOf(delivery) + 1);
        return delivery;
    }


    @Override
    public Delivery findDeliveryByDeliveryId(int deliveryId) {
        LOG.info("Finding delivery with id {}", deliveryId);

        try {
            Delivery delivery = deliveries.get(deliveryId - 1);
            LOG.info("Found delivery {}", delivery);
            return delivery;
        } catch (IndexOutOfBoundsException e) {
            LOG.error("Could not find delivery with id {}", deliveryId, e);
            throw new IllegalArgumentException("Could not find delivery with id " + deliveryId);
        }
    }


    @Override
    public List<Delivery> findAllDeliveries() {
        LOG.info("Finding all deliveries");
        return new ArrayList<>(deliveries);
    }
}
