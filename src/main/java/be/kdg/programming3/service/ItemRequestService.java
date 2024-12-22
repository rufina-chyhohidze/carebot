package be.kdg.programming3.service;

import be.kdg.programming3.domain.ItemRequest;

import java.util.List;

public interface ItemRequestService {
    List<ItemRequest> getAllItemRequests();

    ItemRequest createItemRequest(ItemRequest itemRequest);

    ItemRequest getItemRequestById(int itemRequestId);

    void updateItemRequest(ItemRequest itemRequest);

    List<ItemRequest> getPendingItemRequests();



    List<ItemRequest> getLast5ItemRequests();

    ItemRequest getDeliveryInProgress();
}
