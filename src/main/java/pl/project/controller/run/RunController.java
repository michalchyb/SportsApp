package pl.project.controller.run;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.model.Run;
import pl.project.model.dto.RunDTO;
import pl.project.service.RunService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RunController {

    private RunService runService;

    public RunController(RunService runService) {
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

    @GetMapping(value = "dto/run/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RunDTO getRun(@PathVariable Long id) {
        return runService.getRunDTO(id);
    }
}
