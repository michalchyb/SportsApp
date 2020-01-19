package pl.project.controllers.run;


import org.springframework.web.bind.annotation.*;
import pl.project.models.dtos.RunDTO;
import pl.project.repositories.RunRepository;
import pl.project.services.RunService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api5k/")
public class RunController5K extends RunController {

    private RunRepository runRepository;
    private RunService runService;

    public RunController5K() {
        this.runRepository = runRepository;
        this.runService = runService;
    }

    @GetMapping("dto/runs")
    public List<RunDTO> getRunsDTO(@RequestParam(value = "distance", required = false) Double distance) {
        return runService.getRunsDTO();
    }
}
