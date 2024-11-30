package be.kdg.programming3.service;

import be.kdg.programming3.domain.Item;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ItemService {
//    Item saveItem(Item item);

//    List<Item> getAllItems();

//    Optional<Item> getItemById(int id);

//    List<Item> getItemsByCategory(String category);

//    List<Item> getItemsByName(String name);

//    void deleteItem(int id);

//    void updateStockQuantity(int itemId, int quantity);

    List<String> getItemCategories();
}
