package be.kdg.programming3.repository;

import be.kdg.programming3.domain.ItemRequest;
import org.springframework.stereotype.Repository;

//import java.lang.ScopedValue;
import java.util.List;

@Repository
public interface ItemRequestRepository {
    List<ItemRequest> getAllItemRequests();

    ItemRequest createItemRequest(ItemRequest itemRequest);

    ItemRequest getItemRequestById(int id);

    void updateItemRequest(ItemRequest itemRequest);

    List<ItemRequest> getPendingItemRequests();

    void setItemRequestToCompleted(int itemRequestId);

    List<ItemRequest> getAllItemRequestsOfEmployee(int userId);

    List<ItemRequest> getLast5ItemRequests();

    ItemRequest getDeliveryInProgress();
}
