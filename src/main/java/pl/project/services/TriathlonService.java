package pl.project.services;

import org.springframework.stereotype.Service;
import pl.project.mappers.TriathlonMapper;
import pl.project.models.Triathlon;
import pl.project.models.dtos.TriathlonDTO;
import pl.project.repositories.TriathlonRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriathlonService {

    private TriathlonRepository triathlonRepository;
    private TriathlonMapper triathlonMapper;

    public TriathlonService(TriathlonRepository triathlonRepository, TriathlonMapper triathlonMapper) {
        this.triathlonRepository = triathlonRepository;
        this.triathlonMapper = triathlonMapper;
    }

    public List<TriathlonDTO> getTriathlonsDTO() {
        return triathlonRepository.findAll()
                .stream()
                .map(triathlonMapper::map)
                .collect(Collectors.toList());
    }

    public Triathlon addTriathlon(TriathlonDTO triathlonDTO) {
        return triathlonRepository.save(triathlonMapper.reverseMap(triathlonDTO));
    }

    public void deleteTriathlon(String runName) {
        triathlonRepository.deleteByNameRun(runName);
    }

    public void updateTriathlon(TriathlonDTO triathlonDTO) {
        triathlonRepository.findRunByNameRun(triathlonDTO.getNameRun())
                .ifPresent(r -> {
                    triathlonDTO.setNameRun(triathlonDTO.getNameRun());
                    triathlonDTO.setCity(triathlonDTO.getCity());
                    triathlonDTO.setMyTime(triathlonDTO.getMyTime());
                    triathlonDTO.setDate(triathlonDTO.getDate());
                    triathlonDTO.setDistance(triathlonDTO.getDistance());
                    triathlonDTO.setSwimTime(triathlonDTO.getSwimTime());
                    triathlonDTO.setT1(triathlonDTO.getT1());
                    triathlonDTO.setBikeTime(triathlonDTO.getBikeTime());
                    triathlonDTO.setT2(triathlonDTO.getT2());
                    triathlonDTO.setRunTime(triathlonDTO.getRunTime());
                });
    }

    public List<TriathlonDTO> getTriathlonsByDistance(Double distance) {
        return triathlonRepository.findTriathlonsByDistance(distance)
                .stream()
                .map(triathlonMapper::map)
                .collect(Collectors.toList());
    }

    public List<TriathlonDTO> getLast2825KmTriathlons() {
        return triathlonRepository.findLast2825KmRuns()
                .stream()
                .map(triathlonMapper::map)
                .collect(Collectors.toList());
    }

    public List<TriathlonDTO> getLast5650mTriathlons() {
        return triathlonRepository.findLast5650KmRuns()
                .stream()
                .map(triathlonMapper::map)
                .collect(Collectors.toList());
    }

    public List<TriathlonDTO> getLast11299mTriathlons() {
        return triathlonRepository.findLast11299KmRuns()
                .stream()
                .map(triathlonMapper::map)
                .collect(Collectors.toList());
    }
}
