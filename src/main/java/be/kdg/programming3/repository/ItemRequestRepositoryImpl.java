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
    @Transactional
    public ItemRequest createItemRequest(ItemRequest itemRequest) {
        em.persist(itemRequest);
        return itemRequest;
    }

    @Override
    public List<ItemRequest> findByEmployeeUsername(String username) {
        return List.of();
    }

    @Override
    public List<ItemRequest> findByRequestTimeBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return List.of();
    }

    @Override
    public Optional<ItemRequest> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<ItemRequest> path(PathName path) {
        return List.of();
    }


}
