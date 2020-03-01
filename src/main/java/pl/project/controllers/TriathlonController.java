package pl.project.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}
