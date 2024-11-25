package be.kdg.programming3.service;

import org.springframework.stereotype.Service;
import be.kdg.programming3.domain.*;
import be.kdg.programming3.repository.ItemRequestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ItemRequestServiceImpl implements ItemRequestService {
    private static final Logger LOG = LoggerFactory.getLogger(ItemRequestServiceImpl.class);
    private ItemRequestRepository itemRequestRepository;

    @Autowired
    public ItemRequestServiceImpl(ItemRequestRepository itemRequestRepository) {
        this.itemRequestRepository = itemRequestRepository;
        LOG.debug("ItemRequestServiceImpl instantiated with repository: {}", itemRequestRepository.getClass().getName());
    }

    @Override
    public ItemRequest saveItemRequest(ItemRequest itemRequest) {
        LOG.debug("Saving ItemRequest: {}", itemRequest);
        ItemRequest savedItemRequest = itemRequestRepository.save(itemRequest);
        LOG.debug("Saved ItemRequest: {}", savedItemRequest);
        return savedItemRequest;
    }

    @Override
    public List<ItemRequest> getAllItemRequests() {
        LOG.debug("Fetching all ItemRequests");
        List<ItemRequest> itemRequests = itemRequestRepository.findAll();
        LOG.debug("Found {} ItemRequests", itemRequests.size());
        return itemRequests;
    }

    @Override
    public ItemRequest getItemRequestById(int id) {
        LOG.debug("Fetching ItemRequest by ID: {}", id);
        return itemRequestRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No ItemRequest found with ID: " + id));
    }

    @Override
    public List<ItemRequest> getItemRequestsByEmployee(String username) {
        LOG.debug("Fetching ItemRequests for employee with username: {}", username);
        List<ItemRequest> itemRequests = itemRequestRepository.findByEmployeeUsername(username);
        LOG.debug("Found {} ItemRequests for employee: {}", itemRequests.size(), username);
        return itemRequests;
    }

    @Override
    public List<ItemRequest> getItemRequestsByItemId(int itemId) {
        LOG.debug("Fetching ItemRequests for item with ID: {}", itemId);
        List<ItemRequest> itemRequests = itemRequestRepository.findByItemId(itemId);
        LOG.debug("Found {} ItemRequests for item ID: {}", itemRequests.size(), itemId);
        return itemRequests;
    }

    @Override
    public List<ItemRequest> getItemRequestsByRequestTime(LocalDateTime startTime, LocalDateTime endTime) {
        LOG.debug("Fetching ItemRequests between {} and {}", startTime, endTime);
        List<ItemRequest> itemRequests = itemRequestRepository.findByRequestTimeBetween(startTime, endTime);
        LOG.debug("Found {} ItemRequests between {} and {}", itemRequests.size(), startTime, endTime);
        return itemRequests;
    }

    @Override
    public void deleteItemRequest(int id) {
        LOG.debug("Deleting ItemRequest with ID: {}", id);
        itemRequestRepository.deleteById(id);
        LOG.debug("Deleted ItemRequest with ID: {}", id);
    }
}
