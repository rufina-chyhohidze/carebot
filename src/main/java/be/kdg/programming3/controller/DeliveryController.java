package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import be.kdg.programming3.service.DeliveryService;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;
    private static final Logger LOG = LoggerFactory.getLogger(DeliveryController.class);

    public DeliveryController(DeliveryService deliveryService) {this.deliveryService = deliveryService;}

//    @GetMapping
//    public ResponseEntity<List<Delivery>> getAllDeliveries() {
//        List<Delivery> deliveries = deliveryService.getAllDeliveries();
//        return ResponseEntity.ok(deliveries);
//    }

//    getting a specific delivery by ID
//    @GetMapping("/{id}")
//    public ResponseEntity<Delivery> getDeliveryById(@PathVariable int id) {
//        Delivery delivery = deliveryService.getDeliveryById(id);
//        if (delivery != null) {
//            return ResponseEntity.ok(delivery);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

//    @PostMapping
//    public ResponseEntity<Delivery> addDelivery(@RequestBody Delivery delivery) {
//        deliveryService.addDelivery(delivery);
//        return ResponseEntity.ok(delivery);
//    }

//    @PutMapping("/{id}/finish")
//    public ResponseEntity<Void> finishDelivery(@PathVariable int id, @RequestParam LocalDateTime deliveryFinished) {
//        deliveryService.updateDelivery(id, deliveryFinished);
//        return ResponseEntity.ok().build();
//    }

//    @GetMapping("/deliveries")
//    public String showDeliveries(Model model) {
//        List<List<String>> deliveries = deliveryService.getAllDeliveries();
//        model.addAttribute("deliveries", deliveries);
//        LOG.info("All deliveries: {}", deliveries);
//        return "delivery-list";
//    }
//
//    @PostMapping("/addDelivery")
//    public String addDeliveries(@ModelAttribute Delivery delivery) {
//        LOG.debug("Adding a delivery: {}", delivery);
//        deliveryService.addDelivery(
////                delivery.getDeliveryId(),
//                delivery.getEmployeeId(),
//                delivery.getTotalDeliveryTime()
//        );
//        LOG.info("Successfully added delivery: {}", delivery);
//        return "redirect:/deliveries";
//    }
//
//    @GetMapping("/addDelivery")
//    public String addDeliveryForm(Model model) {
//        model.addAttribute("delivery", new Delivery());
//        return "add-delivery";
//    }

}
