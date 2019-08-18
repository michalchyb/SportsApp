package pl.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("runs")
    public ResponseEntity<List<Run>> getRuns() {
        return runService.getRuns();
    }


//    @GetMapping("dto/runs")
//    public List<RunDTO> getRunsDTO() {
//        return runService.getRunsDTO();
//    }

    @PostMapping("runs")
    public ResponseEntity addRun(@RequestBody Run run) {
        return new ResponseEntity<>(runRepository.save(run), HttpStatus.OK);
    }

    @PostMapping("dto/runs")
    public Run addRun(@RequestBody RunDTO runDTO) {
        return runService.addRun(runDTO);
    }

    @PutMapping("dto/runs")
    public void updateRun(@RequestBody RunDTO runDTO) {
        runService.updateRun(runDTO);
    }

    @DeleteMapping("dto/runs{nameRun}")
    public void deleteRun(@PathVariable String nameRun) {
        runService.deleteRun(nameRun);
    }

    @RequestMapping("runs/findById/{runId}")
    public ResponseEntity<Run> findById(@PathVariable long runId) {
        return ResponseEntity.ok(runRepository.findById(runId));
    }

    @RequestMapping("runs/delete/{runId}")
    public ResponseEntity<Run> deleteById(@PathVariable long runId) {
        runRepository.deleteById(runId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("dto/runs")
    public List<RunDTO> getRunsDTO(@RequestParam(value = "distance", required = false) Double distance) {
        if (distance != null && distance > 0) {
            return runService.getRunsByDistance(distance);
        }
        return runService.getRunsDTO();
    }
}
