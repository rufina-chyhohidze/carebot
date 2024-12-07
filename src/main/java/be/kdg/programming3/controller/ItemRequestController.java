package be.kdg.programming3.controller;


import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.ItemRequestStatus;
import be.kdg.programming3.domain.PathName;
import be.kdg.programming3.service.ItemRequestService;
import be.kdg.programming3.service.ItemService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
    private final SimpMessagingTemplate messagingTemplate;
//    private final EmployeeRepository employeeRepository;

//    private List<Point> points;

    @Autowired
    public ItemRequestController(ItemRequestService itemRequestService, ItemService itemService, SimpMessagingTemplate messagingTemplate) {
        this.itemRequestService = itemRequestService;
        this.itemService = itemService;
        this.messagingTemplate = messagingTemplate;
//        this.employeeRepository = employeeRepository;

//        this.points = initializeManualPoints();
    }


    @GetMapping("/item-request")
    public String showRequestForm(Model model, HttpSession session) {
        if (session.getAttribute("userLoggedIn") == null) return "redirect:/";

        List<String> itemCategories = itemService.getItemCategories();
        System.out.println("itemCategories: " + itemCategories);
        model.addAttribute("items", itemCategories);
        model.addAttribute("paths", PathName.values());
        model.addAttribute("itemRequests", this.itemRequestService.getAllItemRequests());

        return "item-request";
    }

    @PostMapping("/item-request")
    public String sendItemRequest(@RequestParam("item") String itemSelected,
                                  @RequestParam("path") String pathSelected, Model model) {
        List<String> items = itemService.getItemCategories();
        model.addAttribute("items", items);
        model.addAttribute("paths", PathName.values());

        ItemRequest itemRequest = new ItemRequest(itemSelected, PathName.valueOf(pathSelected), "PENDING");
        itemRequest = this.itemRequestService.createItemRequest(itemRequest); // Persisted with id

        // Send a WebSocket message with the itemRequest data to reload warehouse page automatically
        messagingTemplate.convertAndSend("/topic/warehouse-updates", itemRequest);

        return "redirect:/item-request"; // Or you can use a custom response if needed
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
