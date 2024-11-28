package be.kdg.programming3.main;

import be.kdg.programming3.domain.processor.AverageProcessor;
import be.kdg.programming3.domain.processor.SumProcessor;
import be.kdg.programming3.repository.DataProviderProcessor;
import be.kdg.programming3.service.DataProcessorContext;
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

        List<Double> data = DataProviderProcessor.fetchData();

        DataProcessorContext DataContext = new DataProcessorContext();

        /**
         * using sum processor
         */
        DataContext.setDataProcessor(new SumProcessor());
        DataContext.process(data);

        /**
         * using AverageProcessor
         */
        DataContext.setDataProcessor(new AverageProcessor());
        DataContext.process(data);
    }
}
