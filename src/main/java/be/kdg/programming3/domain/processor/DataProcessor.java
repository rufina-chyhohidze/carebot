package be.kdg.programming3.domain.processor;

import java.util.List;

/**
 * interface made for all processing strategies.
 */
public interface DataProcessor {
    void processData(List<Double> data);
}
