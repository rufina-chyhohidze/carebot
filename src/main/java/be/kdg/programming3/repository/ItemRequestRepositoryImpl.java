package be.kdg.programming3.repository;

import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.PathName;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.processor.templateboundaries.ITemplateBoundariesProcessor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class ItemRequestRepositoryImpl implements ItemRequestRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public ItemRequest createItemRequest(ItemRequest itemRequest) {
        em.persist(itemRequest);
        em.flush();
        return itemRequest;
    }

    @Override
    public List<ItemRequest> getAllItemRequests() {
        return em.createQuery("SELECT IR FROM ItemRequest IR", ItemRequest.class).getResultList();
    }

    @Override
    public ItemRequest getItemRequestById(int id) {
        return em.createQuery("SELECT IR FROM ItemRequest IR WHERE IR.id = :id", ItemRequest.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void updateItemRequest(ItemRequest itemRequest) {
        em.merge(itemRequest);
    }

    @Override
    public List<ItemRequest> getAwaitingItemRequests() {
        return em.createQuery("SELECT IR FROM ItemRequest IR WHERE UPPER(IR.status) = 'AWAITING'", ItemRequest.class).getResultList();
    }

//    @Override
//    public List<ItemRequest> findByEmployeeUsername(String username) {
//        return List.of();
//    }
//
//    @Override
//    public List<ItemRequest> findByRequestTimeBetween(LocalDateTime startTime, LocalDateTime endTime) {
//        return List.of();
//    }
//

//
//    @Override
//    public List<ItemRequest> path(PathName path) {
//        return List.of();
//    }


}
