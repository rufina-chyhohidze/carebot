package be.kdg.programming3.domain.processor;

import java.util.List;

public class MaxMinProcessor implements DataProcessor {

    /**
     *
     * @param data
     * identify max and mix values from oncoming data.
     */
    @Override
    public void processData(List<Double> data) {
        double max = data.stream().mapToDouble(Double::doubleValue).max().orElse(Double.NaN);
        double min = data.stream().mapToDouble(Double::doubleValue).min().orElse(Double.NaN);
        System.out.println("Max value of provided data: " + max + ", Min value of provided value: " + min);
    }
}
