package pl.project.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.project.repository.TriathlonRepository;
import pl.project.service.TriathlonService;

@CrossOrigin
@RestController
@RequestMapping("/api/")
public class TriathlonController {

    private TriathlonService triathlonService;

    public TriathlonController(TriathlonService triathlonService) {
        this.triathlonService = triathlonService;
    }
}