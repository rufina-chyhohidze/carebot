package be.kdg.programming3.controller;

import be.kdg.programming3.domain.Delivery;
import be.kdg.programming3.service.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DeliveryController {

    private final DeliveryService deliveryService;
    private static final Logger LOG = LoggerFactory.getLogger(DeliveryController.class);

    public DeliveryController(DeliveryService deliveryService) {this.deliveryService = deliveryService;}

    @GetMapping("/deliveries")
    public String showDeliveries(Model model) {
        List<List<String>> deliveries = deliveryService.getAllDeliveries();
        model.addAttribute("deliveries", deliveries);
        LOG.info("All deliveries: {}", deliveries);
        return "delivery-list";
    }

    @PostMapping("/addDelivery")
    public String addDeliveries(@ModelAttribute Delivery delivery) {
        LOG.debug("Adding a delivery: {}", delivery);
        deliveryService.addDelivery(delivery.getDeliveryId(),
                delivery.getEmployeeId(),
                delivery.getDeliveryTime());
        LOG.info("Successfully added delivery: {}", delivery);
        return "redirect:/deliveries";
    }

//    @GetMapping("/addDeliveries")
//    public String addCourseForm(Model model){
//        LOG.debug("Showing a course form");
//        model.addAttribute("courseTypes", CourseType.values());
//        model.addAttribute("course", new Course());
//        return "addcourse";
//    }
}
