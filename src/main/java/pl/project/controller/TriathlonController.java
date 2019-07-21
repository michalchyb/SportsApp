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

import pl.project.entity.Triathlon;
import pl.project.repository.TriathlonRepository;

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
        return new ResponseEntity<Triathlon>(triathlonRepository.save(triathlon), HttpStatus.OK);
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
