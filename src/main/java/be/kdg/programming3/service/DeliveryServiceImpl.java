package be.kdg.programming3.service;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
    public void setNumberOfObstaclesOfLastDelivery(Integer obstacle) {
        this.deliveryRepository.setNumberOfObstaclesOfLastDelivery(obstacle);
    }

    @Override
    public Delivery createDelivery(Delivery delivery) {
        return this.deliveryRepository.createDelivery(delivery);
    }

    @Override
    public List<Delivery> getAllDeliveries() {
        LOG.info("Retrieving all deliveries");
        return deliveryRepository.getAllDeliveries();
    }

    @Override
    public void setDeliveryInProcessStatusToFinished(LocalDateTime timeFinished) {
        this.deliveryRepository.setDeliveryInProcessStatusToFinished(timeFinished);
    }

    @Override
    public List<Delivery> getPendingDelivery() {
        return this.deliveryRepository.getPendingDelivery();
    }

    @Override
    public Delivery getLastCompletedDelivery() {
        return this.deliveryRepository.getLastCompletedDelivery();
    }

    @Override
    public boolean noDeliveriesInProcess() {
        return this.deliveryRepository.noDeliveriesInProcess();
    }

}
