package pl.project.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pl.project.models.Triathlon;
import pl.project.models.dtos.TriathlonDTO;
import pl.project.repositories.TriathlonRepository;
import pl.project.services.TriathlonService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TriathlonController {

    private TriathlonRepository triathlonRepository;
    private TriathlonService triathlonService;

    public TriathlonController(TriathlonRepository triathlonRepository, TriathlonService triathlonService) {
        this.triathlonRepository = triathlonRepository;
        this.triathlonService = triathlonService;
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

    @PostMapping("dto/triathlons")
    public Triathlon addTriathlon(@RequestBody TriathlonDTO triathlonDTO) {
        return triathlonService.addTriathlon(triathlonDTO);
    }

    @PutMapping("dto/triathlons")
    public void updateTriathlon(@RequestBody TriathlonDTO triathlonDTO) {
        triathlonService.updateTriathlon(triathlonDTO);
    }

    @DeleteMapping("dto/triathlons{nameRun}")
    public void deleteTriathlon(@PathVariable String nameRun) {
        triathlonService.deleteTriathlon(nameRun);
    }

    @GetMapping("dto/triathlons")
    public List<TriathlonDTO> getTriathlonsDTO(@RequestParam(value = "distance", required = false) Double distance) {
        if (distance != null && distance > 0) {
            return triathlonService.getTriathlonsByDistance(distance);
        }
        return triathlonService.getTriathlonsDTO();
    }

}
