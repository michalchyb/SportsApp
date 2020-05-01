package pl.project.controller.run;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.project.model.Run;
import pl.project.model.dto.RunDTO;
import pl.project.service.RunService;

import javax.validation.Valid;
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
    public List<Run> getRuns() {
        return runService.getRuns();
    }

    @GetMapping(value = "dto/runs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RunDTO> getRunsDTO() {
        return runService.getRunsDTO();
    }

    @GetMapping(value = "/run/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Run getRunById(@PathVariable Long id) {
        return runService.getRunById(id);
    }

    @PostMapping(value = "dto/runs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Run addRun(@Valid @RequestBody RunDTO runDTO) {
        return runService.addRun(runDTO);
    }

    @PutMapping(value = "dto/runs",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateRun(@RequestBody RunDTO runDTO) {
        runService.updateRun(runDTO);
    }

    @DeleteMapping(value = "dto/runs/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRun(@PathVariable Long id) {
        runService.deleteRunById(id);
    }
}
