package be.kdg.programming3.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "be.kdg.programming3")
@EnableJpaRepositories("be.kdg.programming3.repository")
@EntityScan("be.kdg.programming3.domain")
public class StartApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(StartApplication.class, args);
    }

}
