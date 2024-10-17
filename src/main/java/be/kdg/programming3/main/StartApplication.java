package be.kdg.programming3.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "be.kdg.programming3")
public class StartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(StartApplication.class, args);
    }

}
