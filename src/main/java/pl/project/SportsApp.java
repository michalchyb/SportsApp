package pl.project;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.project.service.FilesStorageServiceImpl;

import javax.annotation.Resource;

@SpringBootApplication
public class SportsApp implements CommandLineRunner {
    @Resource
    FilesStorageServiceImpl filesStorageService;

    public static void main(String[] args) {
        SpringApplication.run(SportsApp.class, args);


    }

    @Override
    public void run(String... args) throws Exception {
        filesStorageService.init();
    }
}
