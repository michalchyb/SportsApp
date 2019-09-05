package pl.project.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.commons.extras.CreatorXLS;
import pl.project.models.Triathlon;
import pl.project.models.dtos.TriathlonDTO;
import pl.project.repositories.TriathlonRepository;
import pl.project.services.TriathlonService;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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

    @GetMapping("dto/triathlons/2825")
    public List<TriathlonDTO> getLast2825KmRuns() {
        return triathlonService.getLast2825KmTriathlons();
    }

    @GetMapping("dto/triathlons/5650")
    public List<TriathlonDTO> getLast5650KmRuns() {
        return triathlonService.getLast5650mTriathlons();
    }

    @GetMapping("dto/triathlons/11299")
    public List<TriathlonDTO> getLast11299mRuns() {
        return triathlonService.getLast11299mTriathlons();
    }

    @GetMapping("file")
    public String createFile() throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        CreatorXLS<TriathlonDTO> creatorXLS = new CreatorXLS<>(TriathlonDTO.class);
        creatorXLS.createFile(triathlonService.getTriathlonsDTO(), "src/main/", "triathlons");
        return "test";
    }
}
