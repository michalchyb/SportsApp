package pl.project.mappers;

import org.springframework.stereotype.Component;
import pl.project.commons.mapper.Mapper;
import pl.project.models.Run;
import pl.project.models.dtos.RunDTO;

@Component
public class RunMapper implements Mapper<Run, RunDTO> {
    @Override
    public RunDTO map(Run from) {
        return RunDTO
                .builder()
                .nameRun(from.getNameRun())
                .distance(from.getDistance())
                .date(from.getDate())
                .myTime(from.getMyTime())
                .city(from.getCity())
                .build();
    }

    @Override
    public Run reverseMap(RunDTO to) {
        return Run
                .builder()
                .nameRun(to.getNameRun())
                .distance(to.getDistance())
                .date(to.getDate())
                .myTime(to.getMyTime())
                .city(to.getCity())
                .build();
    }
}
