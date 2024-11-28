package be.kdg.programming3.service;

import be.kdg.programming3.domain.processor.DataProcessor;

import java.util.List;

/**
 * manages the logic to apply a strategy, which is a service-layer responsibility.
 * it coordinates between the strategies(AverageProcessor,MaxMinProcessor,SumProcessor) and the data.
 */
public class DataProcessorContext {
    private DataProcessor dataProcessor;


    /**
     * set processing strategy
     * @param dataProcessor
     */
    public void setDataProcessor(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }


    /**
     * delegate data processing to the selected strategy
     * @param data
     */
    public void process(List<Double> data) {
        if (dataProcessor == null) {
            throw new IllegalStateException("No DataProcessor strategy set!");
        }
        dataProcessor.processData(data);
    }
}
