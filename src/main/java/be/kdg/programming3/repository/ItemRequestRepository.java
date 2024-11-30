package be.kdg.programming3.repository;

import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.PathName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRequestRepository {
    List<ItemRequest> findByEmployeeUsername(String username);
//    List<ItemRequest> findByItemId(int itemId);
    List<ItemRequest> findByRequestTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
    Optional<ItemRequest> findById(int id);

    List<ItemRequest> path(PathName path);

    ItemRequest createItemRequest(ItemRequest itemRequest);
}
