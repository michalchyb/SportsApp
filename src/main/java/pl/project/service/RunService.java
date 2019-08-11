package pl.project.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.project.entity.Run;
import pl.project.entity.dtos.RunDTO;
import pl.project.mapper.RunMapper;
import pl.project.repository.RunRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RunService {

    private RunRepository runRepository;
    private RunMapper runMapper;

    public RunService(RunRepository runRepository, RunMapper runMapper) {
        this.runRepository = runRepository;
        this.runMapper = runMapper;
    }

    public ResponseEntity<List<Run>> getRuns() {
        return new ResponseEntity<>(runRepository.findAll(), HttpStatus.OK);
    }

    public List<RunDTO> getRunsDTO() {

        return runRepository
                .findAll()
                .stream()
                .map(runMapper::map )
                .collect(Collectors.toList());
    }

}
