package be.kdg.programming3.service;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private static final Logger LOG = LoggerFactory.getLogger(DeliveryServiceImpl.class);
    private DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
        LOG.debug("DeliveryServiceImpl instantiated with repository {}", deliveryRepository.getClass().getSimpleName());
    }

    @Override
    public void addDelivery(int deliveryId, int employeeId, Timestamp deliveryTime) {
        LOG.debug("Adding delivery with id: {}", deliveryId);
        Delivery delivery = new Delivery(deliveryId, employeeId, deliveryTime);
        deliveryRepository.createDelivery(delivery);
        LOG.debug("Delivery added: {}", delivery);
    }

    @Override
    public List<List<String>> getAllDeliveries() {
        LOG.debug("Getting all deliveries");
        return deliveryRepository.findAllDeliveries();
    }

}
