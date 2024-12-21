package be.kdg.programming3.service;

import be.kdg.programming3.domain.ItemRequest;

import java.util.List;

public interface ItemRequestService {
//    ItemRequest saveItemRequest(ItemRequest itemRequest);
    List<ItemRequest> getAllItemRequests();
//    ItemRequest getItemRequestById(int id);
//    List<ItemRequest> getItemRequestsByEmployee(String username);
//    List<ItemRequest> getItemRequestsByItemId(int itemId);
//    List<ItemRequest> getItemRequestsByRequestTime(LocalDateTime startTime, LocalDateTime endTime);
//    void deleteItemRequest(int id);

    ItemRequest createItemRequest(ItemRequest itemRequest);

    ItemRequest getItemRequestById(int itemRequestId);

    void updateItemRequest(ItemRequest itemRequest);

    List<ItemRequest> getPendingItemRequests();

    void setItemRequestToCompleted(int itemRequestId);

    List<ItemRequest> getAllItemRequestsOfEmployee(int userId);

    List<ItemRequest> getLast5ItemRequests();

    ItemRequest getDeliveryInProgress();
}
