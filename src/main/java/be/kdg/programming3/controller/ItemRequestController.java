package be.kdg.programming3.controller;


import be.kdg.programming3.domain.*;
import be.kdg.programming3.service.DeliveryService;
import be.kdg.programming3.service.EmployeeService;
import be.kdg.programming3.service.ItemRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class ItemRequestController {

    private final ItemRequestService itemRequestService;
    private final SimpMessagingTemplate messagingTemplate;
    private final DeliveryService deliveryService;
    private final EmployeeService employeeService;


    @Autowired
    public ItemRequestController(ItemRequestService itemRequestService, SimpMessagingTemplate messagingTemplate, EmployeeService employeeService, DeliveryService deliveryService) {
        this.itemRequestService = itemRequestService;
        this.messagingTemplate = messagingTemplate;
        this.employeeService = employeeService;
        this.deliveryService = deliveryService;
    }


    @GetMapping("/item-request")
    public String showRequestForm(Model model, HttpSession session) {
        if (session.getAttribute("userLoggedIn") == null) return "redirect:/";

        model.addAttribute("deliveryInProgress", this.itemRequestService.getDeliveryInProgress());
        model.addAttribute("lastDelivery", this.deliveryService.getLastCompletedDelivery());
        model.addAttribute("itemRequests", this.itemRequestService.getAllItemRequests());
        model.addAttribute("pendingItemRequests", this.itemRequestService.getPendingItemRequests());

        return "request-item-page";
    }

    @PostMapping("/item-request")
    public String sendItemRequest(@RequestParam("item") String itemSelected, @RequestParam("path") String pathSelected, Model model, HttpSession session) {
        List<ItemRequest> last5ItemRequests = this.itemRequestService.getLast5ItemRequests();
        if (last5ItemRequests.size() >= 5) return "redirect:/item-request";

        ItemRequest itemRequest = new ItemRequest(itemSelected, PathName.valueOf(pathSelected), ItemRequestStatus.PENDING);
        itemRequest.setEmployee((Employee) session.getAttribute("userLoggedIn"));
        itemRequest = this.itemRequestService.createItemRequest(itemRequest); // Persisted with id

        // Send a WebSocket message with the itemRequest data to reload warehouse page automatically
        messagingTemplate.convertAndSend("/topic/warehouse-updates", itemRequest);


        return "redirect:/item-request";
    }

    @GetMapping("/1")
    public String logInAuto(HttpSession session) {
        Employee employee = this.employeeService.getEmployeeByEmail("user@gmail.com");
        session.setAttribute("userLoggedIn", employee);

        return "redirect:/item-request";
    }
    @GetMapping("/item-request/confirm-delivery/{id}")
    public String confirmDelivery(@PathVariable("id") int id) {
        ItemRequest itemRequest = this.itemRequestService.getItemRequestById(id);
        itemRequest.setStatus(ItemRequestStatus.FULFILLED);
        this.itemRequestService.updateItemRequest(itemRequest);


        this.deliveryService.setDeliveryInProcessStatusToFinished(LocalDateTime.now());
        messagingTemplate.convertAndSend("/topic/warehouse-updates", "message");

        return "redirect:/item-request";
    }
}
