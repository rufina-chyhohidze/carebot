package be.kdg.programming3.controller;

import be.kdg.programming3.domain.*;
import be.kdg.programming3.service.DeliveryService;
import be.kdg.programming3.service.ItemRequestService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseController {

    private final DeliveryService deliveryService;
    private final ItemRequestService itemRequestService;
    public static List<String> deliveryLOG;

    @Autowired
    public WarehouseController(ItemRequestService itemRequestService, DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        this.itemRequestService = itemRequestService;
        deliveryLOG = new ArrayList<>();
    }

    @GetMapping("/warehouse")
    public String showItemRequests(Model model, HttpSession session) {
        if (session.getAttribute("userLoggedIn") == null) return "redirect:/";


        System.out.println("entered warehouse");

        List<ItemRequest> itemRequests = this.itemRequestService.getAwaitingItemRequests();
        model.addAttribute("itemRequests", itemRequests);
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);
        model.addAttribute("deliveryLOG", deliveryLOG);

        return "warehouse";
    }

    @PostMapping("/warehouse")
    public String processItemRequest(@RequestParam("selectedItemRequest") int itemRequestId, Model model) {
        deliveryLOG = new ArrayList<>(); // emptying previous delivery logs


        ItemRequest itemRequestSelected = this.itemRequestService.getItemRequestById(itemRequestId);

        deliveryLOG.add("Delivery started at : " + LocalDateTime.now());
        deliveryLOG.add("Delivering item: " + itemRequestSelected.getItem() + " to path: " + itemRequestSelected.getPath().toString());

        itemRequestSelected.setStatus("FULFILLED");
        this.itemRequestService.updateItemRequest(itemRequestSelected);
        PathName pathSelected = itemRequestSelected.getPath();

        deliveryService.createDelivery(new Delivery(itemRequestSelected, LocalDateTime.now(), DeliveryStatus.PROCESSING));

        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);

        System.err.println("ITEM REQUEST SELECTED: " + itemRequestSelected + " with path: " + pathSelected);



        return "redirect:/data/mode/" + pathSelected;
    }
}
