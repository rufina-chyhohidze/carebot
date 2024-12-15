package be.kdg.programming3.service;

import org.springframework.stereotype.Service;
import be.kdg.programming3.domain.*;
import be.kdg.programming3.repository.ItemRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemRequestServiceImpl implements ItemRequestService {
    private static final Logger LOG = LoggerFactory.getLogger(ItemRequestServiceImpl.class);

    private final ItemRequestRepository itemRequestRepository;

    @Autowired
    public ItemRequestServiceImpl(ItemRequestRepository itemRequestRepository) {
        this.itemRequestRepository = itemRequestRepository;
        LOG.debug("ItemRequestServiceImpl instantiated with repository: {}", itemRequestRepository.getClass().getName());
    }

    @Override
    @Transactional
    public ItemRequest createItemRequest(ItemRequest itemRequest) {
        return this.itemRequestRepository.createItemRequest(itemRequest);
    }

    @Override
    public List<ItemRequest> getPendingItemRequests() {
        return this.itemRequestRepository.getPendingItemRequests();
    }

    @Override
    @Transactional
    public void updateItemRequest(ItemRequest itemRequest) {
        this.itemRequestRepository.updateItemRequest(itemRequest);
    }

    @Override
    public List<ItemRequest> getAllItemRequestsOfEmployee(int userId) {
        return this.itemRequestRepository.getAllItemRequestsOfEmployee(userId);
    }

    @Override
    public List<ItemRequest> getAllItemRequests() {
        LOG.debug("Fetching all ItemRequests");
        List<ItemRequest> itemRequests = itemRequestRepository.getAllItemRequests();
        LOG.debug("Found {} ItemRequests", itemRequests.size());
        return itemRequests;
    }

    @Override
    public ItemRequest getItemRequestById(int id) {
        LOG.debug("Fetching ItemRequest by ID: {}", id);
        return itemRequestRepository.getItemRequestById(id);
    }

    @Override
    public void setItemRequestToCompleted(int itemRequestId) {
        this.itemRequestRepository.setItemRequestToCompleted(itemRequestId);
    }

}
