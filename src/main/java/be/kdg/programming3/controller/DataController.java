package be.kdg.programming3.controller;

import be.kdg.programming3.database.DataBase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataController {
//    DataBase dataBase = new DataBase();
    @PostMapping("/data")
    public ResponseEntity<String> receiveData(@RequestBody Map<String, Object> data) {
        int distance = (int) data.get("distance");
//        if (distance < 10) {
            System.out.println("Received data: " + distance);
            DataBase.insertDistance(distance);
//            System.out.println("Received data: " + distance);
//        }

        return ResponseEntity.ok("Data received successfully");
    }
}