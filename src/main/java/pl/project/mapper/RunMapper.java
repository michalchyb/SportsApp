package pl.project.mapper;

import org.springframework.stereotype.Component;
import pl.project.common.mapper.Mapper;
import pl.project.model.Run;
import pl.project.model.dto.RunDTO;

@Component
public class RunMapper implements Mapper<Run, RunDTO> {
    @Override
    public RunDTO map(Run from) {
        return RunDTO
                .builder()
                .name(from.getName())
                .distance(from.getDistance())
                .date(from.getDate())
                .time(from.getTime())
                .city(from.getCity())
                .build();
    }

    @Override
    public Run reverseMap(RunDTO to) {
        return Run
                .builder()
                .name(to.getName())
                .distance(to.getDistance())
                .date(to.getDate())
                .time(to.getTime())
                .city(to.getCity())
                .build();
    }
}
