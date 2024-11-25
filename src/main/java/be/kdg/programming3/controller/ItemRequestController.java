package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Item;
import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.PathName;
import be.kdg.programming3.domain.Point;
import be.kdg.programming3.service.ItemRequestService;
import be.kdg.programming3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/item-request")
public class ItemRequestController {

    private final ItemRequestService itemRequestService;
    private final ItemService itemService;

    private final List<Point> dropPoints;

    @Autowired
    public ItemRequestController(ItemRequestService itemRequestService, ItemService itemService) {
        this.itemRequestService = itemRequestService;
        this.itemService = itemService;

        this.dropPoints = initializeManualPoints();
    }

    private List<Point> initializeManualPoints() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, PathName.PATH1, "Location 1", false));
        points.add(new Point(2, PathName.PATH2, "Location 2", false));
        points.add(new Point(3, PathName.PATH3, "Location 3", false));

        return points;
    }

    @GetMapping("/item-request")
    public String showRequestForm(Model model) {
        List<Item> items = itemService.getAllItems();
        model.addAttribute("Item", items);
        model.addAttribute("dropPoints", dropPoints);
        return "item-request";
    }

    @PostMapping("/item-request")
    public String sendItemRequest(@RequestParam("itemId") int itemId,
                                  @RequestParam("dropPointId") int pointNumber,
                                  @RequestParam("employeeUsername") String employeeUsername,
                                  Model model) {

        Item selectedItem = itemService.getItemById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + itemId));

        Point selectedPoint = dropPoints.stream()
                .filter(point -> point.getPointNumber() == pointNumber)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid point number: " + pointNumber));

        ItemRequest itemRequest = new ItemRequest();
        itemRequest.setItem(selectedItem);
        itemRequest.setPoint(selectedPoint);
        itemRequest.setRequestTime(LocalDateTime.now());

        itemRequestService.saveItemRequest(itemRequest);

        model.addAttribute("message", "Item request submitted successfully.");
        return "redirect:/item-request"; //this should redirect to the page after succesful submission but we just show the request below right?
    }

    @GetMapping
    public String viewItemRequests(Model model) {
        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
        model.addAttribute("itemRequests", itemRequests);
        return "warehouse";
    }
}
