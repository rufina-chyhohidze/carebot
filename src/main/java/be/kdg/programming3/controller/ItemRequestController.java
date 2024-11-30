package be.kdg.programming3.controller;

import be.kdg.programming3.domain.*;
import be.kdg.programming3.repository.EmployeeRepository;
import be.kdg.programming3.service.ItemRequestService;
import be.kdg.programming3.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
//@RequestMapping("/RequestMappingitem-request")
public class ItemRequestController {

    private final ItemRequestService itemRequestService;
    private final ItemService itemService;
//    private final EmployeeRepository employeeRepository;

//    private List<Point> points;

    @Autowired
    public ItemRequestController(ItemRequestService itemRequestService, ItemService itemService) {
        this.itemRequestService = itemRequestService;
        this.itemService = itemService;
//        this.employeeRepository = employeeRepository;

//        this.points = initializeManualPoints();
    }

//    private List<Point> initializeManualPoints() {
//        points = new ArrayList<>();
//        points.add(new Point(1, PathName.PATH1, "Location 1", false));
//        points.add(new Point(2, PathName.PATH2, "Location 2", false));
//        points.add(new Point(3, PathName.PATH3, "Location 3", false));
//
//        return points;
//    }

    @GetMapping("/item-request")
    public String showRequestForm(Model model) {
        List<String> itemCategories = itemService.getItemCategories();
        System.out.println("itemCategories: " + itemCategories);
        model.addAttribute("items", itemCategories);
        model.addAttribute("paths", PathName.values());

        return "item-request";
    }

    @PostMapping("/item-request")
    public String sendItemRequest(@RequestParam("item") String itemSelected, @RequestParam("path") String pathSelected, Model model) {
        List<String> items = itemService.getItemCategories();
        model.addAttribute("items", items);
        model.addAttribute("paths", PathName.values());

//        System.err.println("Item selected: " + itemSelected + " - Selected path: " + pathSelected);
        System.out.println("Creating itemRequest");
        ItemRequest itemRequest = new ItemRequest(itemSelected, PathName.valueOf(pathSelected));
        System.out.println("item request created (not persisted): " + itemRequest);
        itemRequest = this.itemRequestService.createItemRequest(itemRequest); // persisted and  with id
        System.out.println("item request created NOW PERSISTED WITH ID: " + itemRequest);


        return "redirect:/data/mode/" + pathSelected;
    }


//    previous:
//    @PostMapping("/item-request")
//    public String sendItemRequest(@RequestParam("itemId") int itemId,
//                                  @RequestParam("employeeUsername") String employeeUsername,
//                                  Model model) {
//
//        Item selectedItem = itemService.getItemById(itemId)
//                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + itemId));
//
//        Employee employee = employeeRepository.findByUsername(employeeUsername)
//                .orElseThrow(() -> new IllegalArgumentException("Employee not found with username: " + employeeUsername));
//
//        ItemRequest itemRequest = new ItemRequest();
//        itemRequest.setItem(selectedItem);
//        itemRequest.setEmployee(employee);
//        itemRequest.setRequestTime(LocalDateTime.now());
//
//        itemRequestService.saveItemRequest(itemRequest);
//
//        model.addAttribute("message", "Item request submitted successfully.");
//        return "redirect:/item-request";
//    }

//    @PostMapping("/item-request")
//    public String sendItemRequest(@RequestParam("itemId") int itemId,
//                                  @RequestParam("dropPointId") int pointNumber,
//                                  @RequestParam("employeeUsername") String employeeUsername,
//                                  Model model) {
//
//        Item selectedItem = itemService.getItemById(itemId)
//                .orElseThrow(() -> new IllegalArgumentException("Item not found with ID: " + itemId));
//
//        Point selectedPoint = dropPoints.stream()
//                .filter(point -> point.getPointNumber() == pointNumber)
//                .findFirst()
//                .orElseThrow(() -> new IllegalArgumentException("Invalid point number: " + pointNumber));
//
//        ItemRequest itemRequest = new ItemRequest();
//        itemRequest.setItem(selectedItem);
//        itemRequest.setPoint(selectedPoint);
//        itemRequest.setRequestTime(LocalDateTime.now());
//
//        itemRequestService.saveItemRequest(itemRequest);
//
//        model.addAttribute("message", "Item request submitted successfully.");
//        return "redirect:/item-request"; //this should redirect to the page after succesful submission but we just show the request below right?
//    }

//    @GetMapping("/warehouse")
//    public String viewItemRequests(Model model) {
//        List<ItemRequest> itemRequests = itemRequestService.getAllItemRequests();
//        model.addAttribute("itemRequests", itemRequests);
//        return "warehouse";
//    }
}
