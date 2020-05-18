package pl.project.controller;

import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.project.model.Run;
import pl.project.model.SortBy;
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
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Run> getRuns(@RequestParam(required = false) Integer page, @RequestParam SortBy sortBy, Sort.Direction direction) {
        Integer pageNumber = (page == null || page == 0) ? 0 : page;
        Sort.Direction sortDirection = direction != null ? direction : Sort.Direction.ASC;
        return runService.getRuns(pageNumber, sortBy, sortDirection);

    }

    @GetMapping(value = "dto/runs",
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
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRun(@PathVariable Long id) {
        runService.deleteRunById(id);
    }
}
