package be.kdg.programming3.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataController {
    @PostMapping("/data")
    public ResponseEntity<String> receiveData(@RequestBody Map<String, Object> data) {
        System.out.println("Received data: " + data);

        // You can process or store the data here

        return ResponseEntity.ok("Data received successfully");
    }
}