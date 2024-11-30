package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
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

import java.util.List;

@Controller
public class WarehouseController {

//    private final DeliveryService deliveryService;

    private final ItemRequestService itemRequestService;

    @Autowired
    public WarehouseController(ItemRequestService itemRequestService) {
        this.itemRequestService = itemRequestService;
    }

    @GetMapping("/warehouse")
    public String showItemRequests(Model model) {
//        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        List<ItemRequest> itemRequests = this.itemRequestService.getAllItemRequests();
        model.addAttribute("itemRequests", itemRequests);
        return "warehouse";
    }

    @PostMapping("/warehouse")
    public String processItemRequest(@RequestParam("selectedItemRequest") int itemRequestId, Model model) {

//        System.err.println("\n\n RECEIVED ITEM REQUEST SELECTED : " + itemRequestId + " \n");
        ItemRequest itemRequestSelected = this.itemRequestService.getItemRequestById(itemRequestId);
        PathName pathSelected = itemRequestSelected.getPath();
        System.err.println("ITEM REQUEST SELECTED: " + itemRequestSelected + " with path: " + pathSelected);

//        return "redirect:/warehouse";
        return "redirect:/data/mode/" + pathSelected;
    }
}
