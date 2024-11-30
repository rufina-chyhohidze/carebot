package be.kdg.programming3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@Controller
@RequestMapping("/data")
public class ESP32Controller {

    private String dataForEsp32 = ""; // Stores the data for the ESP32

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
    public ResponseEntity<String> pathInfoReceiver(@RequestBody Map<String, Object> pathInfo) {
        int distance = (int) pathInfo.get("distance");
        System.err.println("\n\n\n RECEIVED DATA: " + pathInfo + " at time: " + LocalDateTime.now() + "\n\n\n");

        return ResponseEntity.ok("Data received successfully");
        /// TODO: Redirect to warhouse (new getmapping that gets the finished path data to store the delivery in the database, then show the delivery information in a website - then test with my hotspot and host website on server - finish preparing talking points for presentation MVP)
    }

}
