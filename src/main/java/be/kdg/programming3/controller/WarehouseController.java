package be.kdg.programming3.controller;

import be.kdg.programming3.config.DeliveryDto;
import be.kdg.programming3.domain.*;
import be.kdg.programming3.service.DeliveryService;
import be.kdg.programming3.service.ItemRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class WarehouseController {

    private final DeliveryService deliveryService;
    private final ItemRequestService itemRequestService;
    public static List<String> deliveryLOG;
    private final SimpMessagingTemplate messagingTemplate;


    @Autowired
    public WarehouseController(ItemRequestService itemRequestService, DeliveryService deliveryService, SimpMessagingTemplate messagingTemplate) {
        this.deliveryService = deliveryService;
        this.itemRequestService = itemRequestService;
        deliveryLOG = new ArrayList<>();
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/warehouse")
    public String showItemRequests(Model model, HttpSession session) {
        if (session.getAttribute("userLoggedIn") == null) return "redirect:/";


        System.out.println("entered warehouse");

        List<ItemRequest> itemRequests = this.itemRequestService.getPendingItemRequests();
        model.addAttribute("itemRequests", itemRequests);
        List<Delivery> deliveries = deliveryService.getPendingDelivery();
        model.addAttribute("deliveries", deliveries);

        List<ItemRequest> last5ItemRequests = this.itemRequestService.getLast5ItemRequests().stream().sorted().toList();
        int counter = 0;
        for (ItemRequest itemRequest : last5ItemRequests) {
            itemRequest.setOrderInLast5ItemRequests(++counter);
        }

        ItemRequest itemRequestInProgress = this.itemRequestService.getDeliveryInProgress();

        model.addAttribute("last5ITemRequests", last5ItemRequests);
        model.addAttribute("deliveryLOG", deliveryLOG);
        model.addAttribute("itemRequestInProgress", itemRequestInProgress);

        Delivery lastDelivery = this.deliveryService.getLastDelivery();
        model.addAttribute("lastDelivery", lastDelivery);


        return "warehouse";
    }

    @PostMapping("/warehouse")
    public String processItemRequest(@RequestParam("selectedItemRequest") int itemRequestId, Model model) {
        if (!this.deliveryService.noDeliveriesInProcess()) return "redirect:/warehouse";

        deliveryLOG = new ArrayList<>(); // emptying previous delivery logs

        ItemRequest itemRequestSelected = this.itemRequestService.getItemRequestById(itemRequestId);

//        this.itemRequestService.setItemRequestToCompleted(itemRequestId);

        deliveryLOG.add("Delivery started at : " + LocalDateTime.now());
        deliveryLOG.add("Delivering item: " + itemRequestSelected.getItem() + " to path: " + itemRequestSelected.getPath().toString());

        itemRequestSelected.setStatus(ItemRequestStatus.PROCESSING);
        this.itemRequestService.updateItemRequest(itemRequestSelected);
        PathName pathSelected = itemRequestSelected.getPath();

        deliveryService.createDelivery(new Delivery(itemRequestSelected, LocalDateTime.now(), DeliveryStatus.PROCESSING));

        List<Delivery> deliveries = deliveryService.getPendingDelivery();
        model.addAttribute("deliveries", deliveries);

        System.err.println("ITEM REQUEST SELECTED: " + itemRequestSelected + " with path: " + pathSelected);

//        List<ItemRequest> last5ItemRequests = this.itemRequestService.getLast5ItemRequests().stream().sorted().toList();
//        int counter = 0;
//        for (ItemRequest itemRequest : last5ItemRequests) {
//            itemRequest.setOrderInLast5ItemRequests(++counter);
//        }

        messagingTemplate.convertAndSend("/topic/start-delivery-progress", "reload item request page");


        return "redirect:/data/mode/" + pathSelected;
    }

    @GetMapping("/warehouse/api/completed-deliveries")
    @ResponseBody
    public List<DeliveryDto> getCompletedDeliveries() {
        // Fetch all completed deliveries from the service
        return deliveryService.getAllDeliveries()
                .stream()
                .filter(delivery -> delivery.getStatus() == DeliveryStatus.COMPLETED)
                .map(delivery -> new DeliveryDto(
                        delivery.getDeliveryId(),
                        delivery.getDeliveryStarted().toString(),
                        delivery.getDeliveryFinished().toString(),
                        delivery.getNumberOfObstacles(),
                        delivery.getItemRequest().getPath().toString()))
                .collect(Collectors.toList());
    }

}
