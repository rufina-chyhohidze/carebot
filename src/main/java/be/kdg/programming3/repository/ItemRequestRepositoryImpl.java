package be.kdg.programming3.repository;

import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.ItemRequestStatus;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ItemRequestRepositoryImpl implements ItemRequestRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public ItemRequest createItemRequest(ItemRequest itemRequest) {
        em.persist(itemRequest);
        return itemRequest;
    }

    @Override
    @Transactional
    public List<ItemRequest> getLast5ItemRequests() {
        return em.createQuery("SELECT ir FROM ItemRequest ir WHERE ir.status = 'PENDING' ORDER BY ir.id DESC FETCH NEXT 5 ROWS ONLY", ItemRequest.class).getResultList();
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

    @Override
    public List<ItemRequest> getAllItemRequestsOfEmployee(int userId) {
        return em.createQuery("SELECT ir FROM ItemRequest ir WHERE ir.employee.id = :id", ItemRequest.class).setParameter("id", userId).getResultList();
    }


}
