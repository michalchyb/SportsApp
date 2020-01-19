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
@RequestMapping("/api/21km")
public class RunController21K extends RunController {

    private RunRepository runRepository;
    private RunService runService;

    public RunController21K(RunRepository runRepository, RunService runService, RunRepository runRepository1) {
        super();
    }


    @GetMapping("dto/runs/21km")
    public List<RunDTO> getLast21kmRuns() {
        return runService.getLast21KmRuns();
    }
}
