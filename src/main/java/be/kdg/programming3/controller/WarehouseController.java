package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WarehouseController {

    private final DeliveryService deliveryService;

    @Autowired
    public WarehouseController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping("/warehouse")
    public String showItemRequests(Model model) {
        List<Delivery> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);
        return "warehouse";
    }
}
