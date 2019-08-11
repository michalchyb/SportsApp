package pl.project.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.entity.Run;
import pl.project.entity.dtos.RunDTO;
import pl.project.repository.RunRepository;
import pl.project.service.RunService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RunController {

    private RunRepository runRepository;
    private RunService runService;
//    public RunController(RunRepository runRepository) {
//        this.runRepository = runRepository;
//    }

    public RunController(RunRepository runRepository, RunService runService) {
        this.runRepository = runRepository;
        this.runService = runService;
    }

    @GetMapping("runs")
    public ResponseEntity<List<Run>> getRuns() {
        return runService.getRuns();
    }


    @GetMapping("dto/runs")
    public List<RunDTO> getRunsDTO() {
        return runService.getRunsDTO();
    }


    @PostMapping("runs")
    public ResponseEntity addRun(@RequestBody Run run) {
        return new ResponseEntity<>(runRepository.save(run), HttpStatus.OK);
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
}