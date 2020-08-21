package pl.project.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
