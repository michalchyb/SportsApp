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

    public List<TriathlonDTO> getTriathlonDTO() {
        return triathlonRepository.findAll()
                .stream()
                .map(triathlonMapper::map)
                .collect(Collectors.toList());
    }

    public Triathlon addTriathlon(TriathlonDTO triathlonDTO) {
        return triathlonRepository.save(triathlonMapper.reverseMap(triathlonDTO));
    }

    public void deleteRun(String runName) {
        triathlonRepository.deleteByNameTriathlon(runName);
    }

    //TODO add update triathlon
}
