package be.kdg.programming3.service;

import be.kdg.programming3.domain.Item;
import be.kdg.programming3.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    List<Item> getAllItems();
}
