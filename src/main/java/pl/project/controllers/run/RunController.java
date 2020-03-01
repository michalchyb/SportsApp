package pl.project.controllers.run;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.repositories.RunRepository;
import pl.project.services.RunService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RunController {

    private RunRepository runRepository;
    private RunService runService;

    public RunController(RunRepository runRepository, RunService runService) {
        this.runRepository = runRepository;
        this.runService = runService;
    }


}
