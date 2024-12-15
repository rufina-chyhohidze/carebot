package be.kdg.programming3.repository;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.domain.DeliveryStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class DeliveryRepositoryImpl implements DeliveryRepository {

    @PersistenceContext
    private final EntityManager em;

    public DeliveryRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public List<Delivery> getAllDeliveries() {
        return em.createQuery("SELECT d FROM Delivery d", Delivery.class).getResultList();
    }

    @Override
    @Transactional
    public Delivery createDelivery(Delivery delivery) {
        if (noDeliveriesInProcess()) em.persist(delivery);

        return delivery;
    }

    @Transactional
    @Override
    public boolean noDeliveriesInProcess() {
        return em.createQuery("SELECT COUNT(d) FROM Delivery d WHERE UPPER(d.status) = 'PROCESSING'", Long.class).getSingleResult() == 0;
    }

    @Override
    @Transactional
    public Delivery getDeliveryById(int id) {
        return em.createQuery("SELECT d FROM Delivery d WHERE d.id = :id", Delivery.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void setDeliveryInProcessStatusToFinished(LocalDateTime timeFinished) {
        Delivery deliveryInProgress = em.createQuery("SELECT d FROM Delivery d WHERE UPPER(d.status) = 'PROCESSING'", Delivery.class).getSingleResult();
        deliveryInProgress.setStatus(DeliveryStatus.COMPLETED);
        deliveryInProgress.setDeliveryFinished(timeFinished);
        em.merge(deliveryInProgress);
    }

    @Override
    public List<Delivery> getPendingDelivery() {
        return em.createQuery("SELECT dr FROM Delivery dr where dr.status = 'PROCESSING'", Delivery.class).getResultList();
    }
}
