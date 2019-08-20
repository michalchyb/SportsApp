package pl.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.project.models.Triathlon;
import pl.project.repositories.TriathlonRepository;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TriathlonController {

    private TriathlonRepository triathlonRepository;

    public TriathlonController(TriathlonRepository triathlonRepository) {
        this.triathlonRepository = triathlonRepository;
    }

    @GetMapping("triathlons")
    public ResponseEntity<List<Triathlon>> getTriathlons() {
        return new ResponseEntity<>(triathlonRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("triathlons")
    public ResponseEntity<Triathlon> addTriathlon(@RequestBody Triathlon triathlon) {
        return new ResponseEntity<>(triathlonRepository.save(triathlon), HttpStatus.OK);
    }

    @RequestMapping("triathlons/findById/{triathlonId}")
    public ResponseEntity<Triathlon> findById(@PathVariable long triathlonId) {
        return ResponseEntity.ok(triathlonRepository.findById(triathlonId));
    }

    @RequestMapping("triathlons/delete/{triathlonId}")
    public ResponseEntity<Triathlon> deleteById(@PathVariable long triathlonId) {
        triathlonRepository.deleteById(triathlonId);
        return ResponseEntity.noContent().build();
    }
}
