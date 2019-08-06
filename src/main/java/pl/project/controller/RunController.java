package pl.project.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.project.entity.Run;
import pl.project.repository.RunRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class RunController {

    private RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("runs")
    public ResponseEntity<List<Run>> getRuns() {
        return new ResponseEntity<>(runRepository.findAll(), HttpStatus.OK);
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
