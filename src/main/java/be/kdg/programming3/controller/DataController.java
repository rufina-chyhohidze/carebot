package be.kdg.programming3.controller;

import be.kdg.programming3.domain.processor.DataProcessor;
import be.kdg.programming3.service.ProcessorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DataController {
    private final ProcessorFactory processorFactory;

    @Autowired
    public DataController(ProcessorFactory processorFactory) {
        this.processorFactory = processorFactory;
    }

    @PostMapping("/data")
    public ResponseEntity<String> receiveData(@RequestBody Map<String, Object> data) {
        int distance = (int) data.get("distance");

            System.out.println("Received data: " + distance);

        return ResponseEntity.ok("Data received successfully");
    }

    // using the processors
    @PostMapping("/processData")
    public ResponseEntity<String> processData(@RequestBody Map<String, Object> data) {
        // or any other data you want to process
        int distance = (int) data.get("distance");

        List<Double> processedData = List.of((double) distance);

        DataProcessor sumProcessor = processorFactory.getProcessor("sum");
        DataProcessor averageProcessor = processorFactory.getProcessor("average");
        DataProcessor maxMinProcessor = processorFactory.getProcessor("maxmin");

        System.out.println("Processing with Sum:");
        sumProcessor.processData(processedData);

        System.out.println("Processing with Average:");
        averageProcessor.processData(processedData);

        System.out.println("Processing with Max/Min:");
        maxMinProcessor.processData(processedData);

        return ResponseEntity.ok("Data processed using sum, average, and max/min.");
    }
}