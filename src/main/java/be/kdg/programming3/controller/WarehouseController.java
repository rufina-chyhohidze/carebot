package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.domain.DeliveryStatus;
import be.kdg.programming3.domain.ItemRequest;
import be.kdg.programming3.domain.PathName;
import be.kdg.programming3.service.DeliveryService;
import be.kdg.programming3.service.ItemRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class WarehouseController {

    private final DeliveryService deliveryService;
    private final ItemRequestService itemRequestService;

    @Autowired
    public WarehouseController(ItemRequestService itemRequestService, DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
        this.itemRequestService = itemRequestService;
    }

    @GetMapping("/warehouse")
    public String showItemRequests(Model model) {
        System.err.println("entered warehouse");
//        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        List<ItemRequest> itemRequests = this.itemRequestService.getAllItemRequests();
        model.addAttribute("itemRequests", itemRequests);
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);

        return "warehouse";
    }

    @PostMapping("/warehouse")
    public String processItemRequest(@RequestParam("selectedItemRequest") int itemRequestId, Model model) {

//        System.err.println("\n\n RECEIVED ITEM REQUEST SELECTED : " + itemRequestId + " \n");
        ItemRequest itemRequestSelected = this.itemRequestService.getItemRequestById(itemRequestId);
        PathName pathSelected = itemRequestSelected.getPath();

        deliveryService.createDelivery(new Delivery(itemRequestSelected, LocalDateTime.now(), DeliveryStatus.PROCESSING));
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);

        System.err.println("ITEM REQUEST SELECTED: " + itemRequestSelected + " with path: " + pathSelected);

//        return "redirect:/warehouse";
        return "redirect:/data/mode/" + pathSelected;
    }

//    @GetMapping("/warehouse/deliveryInProcessFinished")
//    public String updateDelivery(Model model) {
//        System.err.println("\n\n\n ENTERED UPDATE DELIVER MAPPING \n\n\n");
//
//        this.deliveryService.setDeliveryInProcessStatusToFinished(LocalDateTime.now());
//
//        return "redirect:/warehouse";
//    }
}
