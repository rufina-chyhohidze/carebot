package be.kdg.programming3.service;

import be.kdg.programming3.domain.Item;
import be.kdg.programming3.repository.ItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {

    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        logger.debug("Fetching all items from the database");
        List<Item> items = itemRepository.findAll();
        logger.debug("Retrieved {} items from the database", items.size());
        return items;
    }
}
