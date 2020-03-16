package pl.project.controllers.run;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.models.Run;
import pl.project.models.dtos.RunDTO;
import pl.project.repositories.RunRepository;
import pl.project.services.RunService;

import java.util.List;

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

    @GetMapping(value = "runs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Run>> getRuns() {
        return runService.getRuns();
    }

    @GetMapping(value = "dto/runs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RunDTO> getRunsDTO() {
        return runService.getRunsDTO();
    }
}
