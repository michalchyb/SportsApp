package pl.project.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.project.exception.RunNotFoundByIdException;
import pl.project.exception.RunNotFoundException;
import pl.project.exception.RunsNotFoundException;
import pl.project.mapper.RunMapper;
import pl.project.model.Run;
import pl.project.model.SortBy;
import pl.project.model.dto.RunDTO;
import pl.project.repository.RunRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RunService {

    private static final int PAGE_SIZE = 10;
    private RunRepository runRepository;
    private RunMapper runMapper;

    public RunService(RunRepository runRepository, RunMapper runMapper) {
        this.runRepository = runRepository;
        this.runMapper = runMapper;
    }

    public List<Run> getRuns(Integer page, SortBy sortBy, Sort.Direction sortDirection) {
        List<Run> runs = runRepository.findAllRuns(PageRequest.of(page, PAGE_SIZE, Sort.by(sortDirection, sortBy.toString().toLowerCase())));
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

    @Transactional
    public void updateRun(RunDTO runDTO) {
        runRepository.findById(runDTO.getId())
                .ifPresent(r -> {
                    runDTO.setName(runDTO.getName());
                    runDTO.setCity(runDTO.getCity());
                    runDTO.setTime(runDTO.getTime());
                    runDTO.setDate(runDTO.getDate());
                    runDTO.setDistance(runDTO.getDistance());
                    runRepository.save(r);
                });

    }

    @Transactional
    public void deleteRunById(Long id) {
        if (!runRepository.existsById(id)) {
            throw new RunNotFoundByIdException(id);
        }
        runRepository.deleteById(id);
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