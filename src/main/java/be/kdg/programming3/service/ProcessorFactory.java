package be.kdg.programming3.service;

import be.kdg.programming3.domain.processor.AverageProcessor;
import be.kdg.programming3.domain.processor.DataProcessor;
import be.kdg.programming3.domain.processor.MaxMinProcessor;
import be.kdg.programming3.domain.processor.SumProcessor;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class ProcessorFactory {
    private final Map<String, DataProcessor> processorMap = new HashMap<>();

    /**
     * private constructor to "hide it", the part of factory pattern
     * we avoid the creating of new instances of this class
     */
    private ProcessorFactory() {
        processorMap.put("sum", new SumProcessor());
        processorMap.put("average", new AverageProcessor());
        processorMap.put("maxmin", new MaxMinProcessor());
    }

    public DataProcessor getProcessor(String eventType) {
        DataProcessor processor = processorMap.get(eventType.toLowerCase());
        if (processor == null) {
            throw new IllegalArgumentException("No processor found for event type: " + eventType);
        }
        return processor;
    }
}