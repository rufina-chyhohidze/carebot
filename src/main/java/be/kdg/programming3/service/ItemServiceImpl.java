package be.kdg.programming3.service;

import be.kdg.programming3.domain.Item;
import be.kdg.programming3.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Logger LOG = LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        LOG.debug("ItemServiceImpl instantiated with repository: {}", itemRepository.getClass().getName());
    }

//    @Override
//    public Item saveItem(Item item) {
//        LOG.debug("Entering saveItem method with item: {}", item);
//        Item savedItem = itemRepository.save(item);
//        LOG.debug("Item saved successfully: {}", savedItem);
//        return savedItem;
//    }
//
//    @Override
//    public List<Item> getAllItems() {
//        LOG.debug("Fetching all items from the database.");
//        List<Item> items = itemRepository.findAll();
//        LOG.debug("Found {} items", items.size());
//        return items;
//    }
//
//    @Override
//    public Optional<Item> getItemById(int id) {
//        LOG.debug("Fetching item with ID: {}", id);
//        Optional<Item> item = itemRepository.findById(id);
//        if (item.isPresent()) {
//            LOG.debug("Item found: {}", item.get());
//        } else {
//            LOG.debug("No item found with ID: {}", id);
//        }
//        return item;
//    }

//    @Override
//    public List<Item> getItemsByCategory(String category) {
//        LOG.debug("Fetching items by category: {}", category);
//        List<Item> items = itemRepository.findByCategory(category);
//        LOG.debug("Found {} items in category '{}'", items.size(), category);
//        return items;
//    }

//    @Override
//    public List<Item> getItemsByName(String name) {
//        LOG.debug("Fetching items by name containing: {}", name);
//        List<Item> items = itemRepository.findByNameContaining(name);
//        LOG.debug("Found {} items with name containing '{}'", items.size(), name);
//        return items;
//    }
//
//    @Override
//    public void deleteItem(int id) {
//        LOG.debug("Deleting item with ID: {}", id);
//        itemRepository.deleteById(id);
//        LOG.debug("Item with ID {} deleted successfully", id);
//    }

//    @Override
//    public void updateStockQuantity(int itemId, int quantity) {
//        LOG.debug("Updating stock quantity for item with ID: {}. New quantity: {}", itemId, quantity);
//        Optional<Item> item = getItemById(itemId);
//        item.ifPresent(i -> {
//            i.setStockQuantity(i.getStockQuantity() + quantity); // adjust the stock quantity
//            saveItem(i); // save the updated item
//            LOG.debug("Stock quantity updated for item: {}", i);
//        });
//        item.orElseGet(() -> {
//            LOG.debug("Item with ID {} not found, stock update failed.", itemId);
//            return null;
//        });
//    }
    @Override
    public List<String> getItemCategories() {
        return this.itemRepository.getCategories();
    }
}
