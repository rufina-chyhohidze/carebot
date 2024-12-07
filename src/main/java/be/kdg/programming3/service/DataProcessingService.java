package be.kdg.programming3.service;

import be.kdg.programming3.domain.processor.DataProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * manages the logic to apply a strategy, which is a service-layer responsibility.
 * it coordinates between the strategies(AverageProcessor,MaxMinProcessor,SumProcessor) and the data.
 */
@Service
public class DataProcessingService {
    private final ProcessorFactory processorFactory;
    private final CompositeProcessor compositeProcessor;

    @Autowired
    public DataProcessingService(ProcessorFactory processorFactory, CompositeProcessor compositeProcessor) {
        this.processorFactory = processorFactory;
        this.compositeProcessor = compositeProcessor;
    }

    public void processData(String eventType, List<Double> data) {
        if (eventType.equals("composite")) {
            compositeProcessor.addProcessor(processorFactory.getProcessor("sum"));
            compositeProcessor.addProcessor(processorFactory.getProcessor("average"));
            compositeProcessor.addProcessor(processorFactory.getProcessor("maxmin"));
            compositeProcessor.processData(data);
        } else {
            DataProcessor processor = processorFactory.getProcessor(eventType);
            processor.processData(data);
        }
    }
}