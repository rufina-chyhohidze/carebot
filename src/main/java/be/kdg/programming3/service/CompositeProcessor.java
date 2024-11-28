package be.kdg.programming3.service;

import be.kdg.programming3.domain.processor.DataProcessor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompositeProcessor implements DataProcessor {
    private List<DataProcessor> processors = new ArrayList<>();

    public void addProcessor(DataProcessor processor) {
        processors.add(processor);
    }

    @Override
    public void processData(List<Double> data) {
        for (DataProcessor processor : processors) {
            processor.processData(data);
        }
    }
}