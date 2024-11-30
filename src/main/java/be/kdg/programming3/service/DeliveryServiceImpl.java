package be.kdg.programming3.service;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private static final Logger LOG = LoggerFactory.getLogger(DeliveryServiceImpl.class);
    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
        LOG.debug("DeliveryServiceImpl instantiated with repository {}", deliveryRepository.getClass().getSimpleName());
    }

//    @Override
//    public List<List<String>> getAllDeliveries() {
//        LOG.info("Retrieving all deliveries");
//
//        List<Delivery> deliveries = deliveryRepository.findAll();  // JPA method
//
//        return deliveries.stream()
//                .map(delivery -> List.of(
//                        String.valueOf(delivery.getDeliveryId()),
//                        String.valueOf(delivery.getTotalDeliveryTime()),
//                        String.valueOf(delivery.getEmployeeId())
//                ))
//                .collect(Collectors.toList());
//    }
    @Override
    public List<Delivery> getAllDeliveries() {
        LOG.info("Retrieving all deliveries");
        return deliveryRepository.findAll();
    }

    @Override
    public Delivery getDeliveryById(int deliveryId) {
        LOG.info("Fetching delivery with ID: {}", deliveryId);
        Optional<Delivery> delivery = deliveryRepository.findById(deliveryId);
        return deliveryRepository.findById(deliveryId).orElse(null);
    }

    @Override
    public void addDelivery(Delivery delivery) {
        LOG.debug("Adding new delivery: {}", delivery);
        deliveryRepository.save(delivery);
        LOG.info("Delivery added: {}", delivery);
    }

//    @Override
//    public void addDelivery(int employeeId, Timestamp deliveryTime) {
//        LOG.debug("Adding new delivery for employeeId: {}", employeeId);
//
//        Delivery delivery = new Delivery(); // Don't set deliveryId, it's auto-generated
//        delivery.setEmployeeId(employeeId);
//        delivery.setTotalDeliveryTime(deliveryTime);
//
//        deliveryRepository.save(delivery); // Save will handle the ID generation
//        LOG.info("Delivery added: {}", delivery);
//    }

    @Override
    public void updateDelivery(int deliveryId, LocalDateTime deliveryFinished) {
        LOG.info("Updating delivery with ID: {}", deliveryId);

        Optional<Delivery> optionalDelivery = deliveryRepository.findById(deliveryId);
        if (optionalDelivery.isPresent()) {
            Delivery delivery = optionalDelivery.get();
            delivery.setDeliveryFinished(deliveryFinished);
            delivery.calculateTotalDeliveryTime();
            deliveryRepository.save(delivery);
            LOG.info("Delivery updated: {}", delivery);
        } else {
            LOG.warn("Delivery with ID: {} not found", deliveryId);
        }
    }

}
