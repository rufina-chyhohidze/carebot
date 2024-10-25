package be.kdg.programming3.service;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private static final Logger LOG = LoggerFactory.getLogger(DeliveryServiceImpl.class);
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
        LOG.debug("DeliveryServiceImpl instantiated with repository {}", deliveryRepository.getClass().getSimpleName());
    }

    @Override
    public List<List<String>> getAllDeliveries() {
        LOG.info("Retrieving all deliveries");

        List<Delivery> deliveries = deliveryRepository.findAll();  // JPA method

        return deliveries.stream()
                .map(delivery -> List.of(
                        String.valueOf(delivery.getDeliveryId()),
                        String.valueOf(delivery.getDeliveryTime()),
                        String.valueOf(delivery.getEmployeeId())
                ))
                .collect(Collectors.toList());
    }

    @Override
    public void addDelivery(int deliveryId, int employeeId, Timestamp deliveryTime) {
        LOG.debug("Adding new delivery for employeeId: {}", employeeId);
        Delivery delivery = new Delivery();
        delivery.setDeliveryId(deliveryId);
        delivery.setEmployeeId(employeeId);
        delivery.setDeliveryTime(deliveryTime);
        deliveryRepository.save(delivery);
        LOG.info("Delivery added: {}", delivery);
    }

}
