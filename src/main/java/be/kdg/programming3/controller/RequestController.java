package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Item;
import be.kdg.programming3.domain.PathName;
import be.kdg.programming3.repository.ItemRepository;
import be.kdg.programming3.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class RequestController {

    private static final Logger logger = LoggerFactory.getLogger(RequestController.class);

    @Autowired
    private ItemService itemService;

    @GetMapping("/request-form")
    public String showRequestForm(Model model) {
        logger.debug("Entering showRequestForm method");

        List<Item> items = itemService.getAllItems();
        if (items.isEmpty()) {
            logger.warn("No items found in the database");
        } else {
            logger.debug("Retrieved {} items from the database", items.size());
        }

        model.addAttribute("items", items);

        // Add drop points dynamically from the PathName enum
        List<String> dropPoints = Arrays.stream(PathName.values())
                .map(Enum::name)
                .toList();
        model.addAttribute("pathNames", dropPoints);

        logger.debug("Added items and dropPoints (from PathName enum) to the model");
        return "request-form";
    }
}


