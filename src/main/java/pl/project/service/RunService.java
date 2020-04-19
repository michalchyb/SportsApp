package pl.project.service;

import org.springframework.stereotype.Service;
import pl.project.exception.RunNotFoundException;
import pl.project.exception.RunsNotFoundException;
import pl.project.mapper.RunMapper;
import pl.project.model.Run;
import pl.project.model.dto.RunDTO;
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

    public List<Run> getRuns() {
        List<Run> runs = runRepository.findAll();
        if (runs.isEmpty()) {
            throw new RunsNotFoundException();
        }
        return runs;
    }

    public List<RunDTO> getRunsDTO() {
        List<RunDTO> runsDto = runRepository
                .findAll()
                .stream()
                .map(runMapper::map)
                .collect(Collectors.toList());

        if (runsDto.isEmpty()) {
            throw new RunsNotFoundException();
        }
        return runsDto;
    }

    public Run getRunById(Long id) {
        return runRepository.findById(id)
                .orElseThrow(() -> new RunNotFoundException(id));
    }

    public Run addRun(RunDTO runDTO) {
        return runRepository.save(runMapper.reverseMap(runDTO));
    }

    public void updateRun(RunDTO runDTO) {
        runRepository.findRunByNameRun(runDTO.getNameRun())
                .ifPresent(r -> {
                    runDTO.setNameRun(runDTO.getNameRun());
                    runDTO.setCity(runDTO.getCity());
                    runDTO.setMyTime(runDTO.getMyTime());
                    runDTO.setDate(runDTO.getDate());
                    runDTO.setDistance(runDTO.getDistance());

                    runRepository.save(r);
                });

    }

    public void deleteRun(String runName) {
        runRepository.deleteByNameRun(runName);
    }

    public List<RunDTO> getRunsByDistance(Double distance) {
        return runRepository.findRunsByDistance(distance)
                .stream()
                .map(runMapper::map)
                .collect(Collectors.toList());
    }

    public List<RunDTO> getLast5KmRuns() {
        return runRepository.findLast5KmRuns()
                .stream()
                .map(runMapper::map)
                .collect(Collectors.toList());
    }

    public List<RunDTO> getLast10KmRuns() {
        return runRepository.findLast10KmRuns()
                .stream()
                .map(runMapper::map)
                .collect(Collectors.toList());
    }

    public List<RunDTO> getLast21KmRuns() {
        return runRepository.findLast21KmRuns()
                .stream()
                .map(runMapper::map)
                .collect(Collectors.toList());
    }
}