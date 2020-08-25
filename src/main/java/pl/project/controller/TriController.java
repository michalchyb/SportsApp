package pl.project.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.project.model.Tri;
import pl.project.service.TriService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TriController {

    private TriService triService;

    public TriController(TriService triService) {
        this.triService = triService;
    }

    @GetMapping(value = "tris",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Tri> getTris(){
        return triService.getTriathlons();
    }

    @PostMapping(value = "tris",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Tri addTri( @RequestBody Tri tri) {
        return triService.addTri(tri);
    }
}
