package pl.project;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SportsApp {
    private static final Logger logger = LogManager.getLogger(SportsApp.class);

    public static void main(String[] args) {

        SpringApplication.run(SportsApp.class, args);
    }
}
