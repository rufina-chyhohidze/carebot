//package be.kdg.programming3.controller;
//
//import be.kdg.programming3.domain.Employee;
//import be.kdg.programming3.domain.ItemRequest;
//import be.kdg.programming3.domain.ItemRequestStatus;
//import be.kdg.programming3.domain.PathName;
//import be.kdg.programming3.service.DeliveryService;
//import be.kdg.programming3.service.ItemRequestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.ui.Model;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/new")
//public class DashboardController {
//
//    private final ItemRequestService itemRequestService;
//    private final DeliveryService deliveryService;
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    public DashboardController(ItemRequestService itemRequestService, DeliveryService deliveryService, SimpMessagingTemplate messagingTemplate) {
//        this.itemRequestService = itemRequestService;
//        this.deliveryService = deliveryService;
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    @GetMapping
//    public String userDashboard(Model model, HttpSession session) {
//
//        model.addAttribute("deliveryInProgress", this.itemRequestService.getDeliveryInProgress());
//        model.addAttribute("lastDelivery", this.deliveryService.getLastCompletedDelivery());
//        model.addAttribute("itemRequests", this.itemRequestService.getAllItemRequests());
//
//        return "request-item-page";
//    }
//    @PostMapping
//    public String sendItemRequest(@RequestParam("item") String itemSelected, @RequestParam("path") String pathSelected, Model model, HttpSession session) {
//        List<ItemRequest> last5ItemRequests = this.itemRequestService.getLast5ItemRequests();
//        if (last5ItemRequests.size() >= 5) return "redirect:/item-request";
//
//        ItemRequest itemRequest = new ItemRequest(itemSelected, PathName.valueOf(pathSelected), ItemRequestStatus.PENDING);
//        itemRequest.setEmployee((Employee) session.getAttribute("userLoggedIn"));
//        itemRequest = this.itemRequestService.createItemRequest(itemRequest); // Persisted with id
//
//        // Send a WebSocket message with the itemRequest data to reload warehouse page automatically
//        messagingTemplate.convertAndSend("/topic/warehouse-updates", itemRequest);
//
//
//        return "redirect:/new"; // Or you can use a custom response if needed
//    }
//
//
//}
