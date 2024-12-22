package be.kdg.programming3.controller;

import be.kdg.programming3.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * This controller handles the two-way communication between the spring app and the arduino/wifi module
 */
@Controller
@RequestMapping("/data")
public class ESP32Controller {

    private final DeliveryService deliveryService;
    private final SimpMessagingTemplate messagingTemplate;
    private String dataForEsp32 = ""; // Stores the data for the ESP32

    @Autowired
    public ESP32Controller(DeliveryService deliveryService, SimpMessagingTemplate messagingTemplate) {
        this.deliveryService = deliveryService;
        this.messagingTemplate = messagingTemplate;
    }

    // Endpoint for ESP32 to check for data
    @GetMapping("/esp32")
    @ResponseBody
    public ResponseEntity<String> getDataForEsp32() {
        if (!dataForEsp32.isEmpty()) {
            String data = dataForEsp32;
            dataForEsp32 = ""; // Clear data after sending to ESP32
            return ResponseEntity.ok(data);
        }
        return ResponseEntity.noContent().build(); // No data to send
    }

    @GetMapping("/mode/{mode}")
    public String sendModeToEsp32(@PathVariable String mode) {
        dataForEsp32 = mode; // Set the mode as the data

        return "redirect:/warehouse";
    }

    @PostMapping("/pathInfoReceiver")
    public ResponseEntity<String>  pathInfoReceiver(@RequestBody Map<String, Object> pathInfo) {
        Integer obstacle = (Integer) pathInfo.get("obstacle");
        System.err.println("\n\n\n RECEIVED DATA: " + pathInfo + " at time: " + LocalDateTime.now() + "\n\n\n");

        if (obstacle == 12341234) {
            System.err.println("\n\nOBSTACLE\n\n");
            WarehouseController.deliveryLOG.add("Robot STOPPED -> Obstacle found at: " + LocalDateTime.now());
            messagingTemplate.convertAndSend("/topic/warehouse-updates", "message");

            return ResponseEntity.ok("Data received successfully");
        }
        if (obstacle == 43214321) {
            WarehouseController.deliveryLOG.add("Obstacle CLEARED  - Robot continues at: " + LocalDateTime.now());
            messagingTemplate.convertAndSend("/topic/warehouse-updates", "message");

            return ResponseEntity.ok("Data received successfully");
        }
        this.deliveryService.setNumberOfObstaclesOfLastDelivery(obstacle);

        WarehouseController.deliveryLOG.add("Delivery COMPLETED at: " + LocalDateTime.now() + " - Number of Obstacles Found: " + obstacle);


        messagingTemplate.convertAndSend("/topic/warehouse-updates", "message");


        return ResponseEntity.ok("Data received successfully");
    }

    @GetMapping("/control")
    public String control() {
        return "control-car";
    }
}
