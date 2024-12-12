package be.kdg.programming3.repository;

import be.kdg.programming3.domain.ItemRequest;
import org.springframework.stereotype.Repository;

//import java.lang.ScopedValue;
import java.util.List;

@Repository
public interface ItemRequestRepository {
    List<ItemRequest> getAllItemRequests();
//    List<ItemRequest> findByEmployeeUsername(String username);
//    List<ItemRequest> findByItemId(int itemId);
//    List<ItemRequest> findByRequestTimeBetween(LocalDateTime startTime, LocalDateTime endTime);
//    Optional<ItemRequest> findById(int id);

//    List<ItemRequest> path(PathName path);

    ItemRequest createItemRequest(ItemRequest itemRequest);

    ItemRequest getItemRequestById(int id);

    void updateItemRequest(ItemRequest itemRequest);

    List<ItemRequest> getPendingItemRequests();
}
