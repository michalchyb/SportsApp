package pl.project.controllers.run;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.models.dtos.RunDTO;
import pl.project.repositories.RunRepository;
import pl.project.services.RunService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/10km")
public class RunController10K extends  RunController {

    private RunRepository runRepository;
    private RunService runService;

    public RunController10K(RunRepository runRepository, RunService runService, RunRepository runRepository1) {
        super();
    }

    @GetMapping("dto/runs/10km")
    public List<RunDTO> getLast10KmRuns() {
        return runService.getLast10KmRuns();
    }

}

