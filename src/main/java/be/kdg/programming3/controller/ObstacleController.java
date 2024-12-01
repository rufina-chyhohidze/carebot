//package be.kdg.programming3.controller;
//
//import be.kdg.programming3.domain.Obstacle;
//import be.kdg.programming3.domain.Delivery;
//import be.kdg.programming3.service.ObstacleService;
//import be.kdg.programming3.service.DeliveryService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/obstacles")
//public class ObstacleController {
//
//    private final ObstacleService obstacleService;
//    private final DeliveryService deliveryService;
//    private static final Logger LOG = LoggerFactory.getLogger(ObstacleController.class);
//
//    public ObstacleController(ObstacleService obstacleService, DeliveryService deliveryService) {
//        this.obstacleService = obstacleService;
//        this.deliveryService = deliveryService;
//    }
//
//    // Endpoint to show the list of obstacles
//    @GetMapping
//    public String showObstacles(Model model) {
//        List<Obstacle> obstacles = obstacleService.getAllObstacles();
//        model.addAttribute("obstacles", obstacles);
//        return "obstacle-list";
//    }
//
//    // Form to add a new obstacle
////    @GetMapping("/add")
////    public String addObstacleForm(Model model) {
////        // Get all deliveries for selection when adding an obstacle
////        List<Delivery> deliveries = deliveryService.getAllDeliveries();  // Assuming `getAllDeliveries` exists
////        model.addAttribute("deliveries", deliveries);
////        model.addAttribute("obstacle", new Obstacle());
////        return "add-obstacle";
////    }
//
//    // Handling the form submission for adding a new obstacle
//    @PostMapping("/add")
//    public String addObstacle(@ModelAttribute Obstacle obstacle, @RequestParam Long deliveryId) {
//        LOG.debug("Adding new obstacle: {}", obstacle);
//
//        // Convert deliveryId from Long to int (since DeliveryId is int)
//        int deliveryIdInt = deliveryId.intValue(); // Convert Long to int
//
//        // Find the Delivery object by its ID and associate it with the obstacle
//        Delivery delivery = deliveryService.getDeliveryById(deliveryIdInt);  // Now passing an int
//        if (delivery != null) {
//            obstacle.setDelivery(delivery);
//            obstacleService.addObstacle(obstacle);
//            LOG.info("Obstacle added: {}", obstacle);
//        } else {
//            LOG.error("Delivery with ID {} not found.", deliveryIdInt);
//            // Handle the case where the delivery is not found
//        }
//
//        return "redirect:/obstacles";
//    }
//
//    // Endpoint to view a specific obstacle by its ID
//    @GetMapping("/{id}")
//    public String viewObstacle(@PathVariable Long id, Model model) {
//        Obstacle obstacle = obstacleService.getObstacleById(id);
//        if (obstacle != null) {
//            model.addAttribute("obstacle", obstacle);
//            return "view-obstacle";
//        } else {
//            return "error/404"; // Render a 404 error page if obstacle not found
//        }
//    }
//}