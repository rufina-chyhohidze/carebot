package be.kdg.programming3.main;

import be.kdg.programming3.domain.processor.AverageProcessor;
import be.kdg.programming3.domain.processor.DataProcessor;
import be.kdg.programming3.domain.processor.MaxMinProcessor;
import be.kdg.programming3.domain.processor.SumProcessor;
import be.kdg.programming3.repository.DataProviderProcessor;
import be.kdg.programming3.service.CompositeProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication(scanBasePackages = "be.kdg.programming3")
@EnableJpaRepositories("be.kdg.programming3.repository")
@EntityScan("be.kdg.programming3.domain")
public class StartApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(StartApplication.class, args);

        // Data Processor
        List<Double> distanceData = DataProviderProcessor.distanceData();

        List<Double> deliveryData = DataProviderProcessor.deliveryData();

        DataProcessor sumProcessor = new SumProcessor();
        DataProcessor averageProcessor = new AverageProcessor();
        DataProcessor maxMinProcessor = new MaxMinProcessor();

        CompositeProcessor compositeProcessor = new CompositeProcessor();
        compositeProcessor.addProcessor(sumProcessor);
        compositeProcessor.addProcessor(averageProcessor);
        compositeProcessor.addProcessor(maxMinProcessor);

        System.out.println("Processing distance data with CompositeProcessor:");
        compositeProcessor.processData(distanceData);

        System.out.println("Processing delivery data with CompositeProcessor:");
        compositeProcessor.processData(deliveryData);
    }
}