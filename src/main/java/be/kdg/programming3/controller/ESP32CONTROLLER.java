package be.kdg.programming3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/data")
public class ESP32CONTROLLER {


        private String dataForEsp32 = ""; // Stores the data for the ESP32

        // Endpoint to display the form in Thymeleaf
        @GetMapping("/send")
        public String showForm(Model model) {
            model.addAttribute("message", ""); // Placeholder for feedback messages
            return "sendForm";
        }

        // Endpoint to handle form submission and store data
        @PostMapping("/send")
        public String sendData(@RequestParam("data") String data, Model model) {
            dataForEsp32 = data;
            model.addAttribute("message", "Data sent successfully!");
            return "sendForm";
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


}
