package be.kdg.programming3.repository;

import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.ItemRequestStatus;
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

    public ItemRequestRepositoryImpl() {
//        System.err.println("\n\n\n PERSISITNG ALL EXISTING VALUES IN DB\n\n\n");
//        List<ItemRequest> allExistingItemRequests = em.createQuery("SELECT ir FROM ItemRequest ir", ItemRequest.class).getResultList();
//        System.err.println("\nALL ITEM REQUESTS: " + allExistingItemRequests + " \n\n\n");
//        allExistingItemRequests.forEach(itemRequest -> em.persist(itemRequest));
    }

//    private boolean allExistingItemsInDBPersisted = false;

    @Override
    @Transactional
    public ItemRequest createItemRequest(ItemRequest itemRequest) {
        System.err.println("\n\n\n PERSISITNG ALL EXISTING VALUES IN DB\n\n\n");



//        if (!allExistingItemsInDBPersisted) {
//            final List<ItemRequest> allExistingItemRequests = em.createQuery("SELECT ir FROM ItemRequest ir", ItemRequest.class).getResultList();
//            allExistingItemRequests.forEach(itemRequestFound -> em.merge(itemRequestFound));
//            allExistingItemsInDBPersisted = true;
//        }

        em.persist(itemRequest);
        return itemRequest;
    }

    @Override
    @Transactional
    public List<ItemRequest> getAllItemRequests() {
        return em.createQuery("SELECT IR FROM ItemRequest IR", ItemRequest.class).getResultList();
    }

    @Override
    @Transactional
    public ItemRequest getItemRequestById(int id) {
        return em.createQuery("SELECT IR FROM ItemRequest IR WHERE IR.id = :id", ItemRequest.class).setParameter("id", id).getSingleResult();
    }

    @Override
    @Transactional
    public void updateItemRequest(ItemRequest itemRequest) {
        em.merge(itemRequest);
    }

    @Override
    @Transactional
    public List<ItemRequest> getPendingItemRequests() {
        return em.createQuery("SELECT IR FROM ItemRequest IR WHERE UPPER(IR.status) = 'PENDING'", ItemRequest.class).getResultList();
    }

    @Override
    @Transactional
    public void setItemRequestToCompleted(int itemRequestId) {
        ItemRequest itemRequest = getItemRequestById(itemRequestId);
        itemRequest.setStatus(ItemRequestStatus.FULFILLED);
        em.merge(itemRequest);
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
