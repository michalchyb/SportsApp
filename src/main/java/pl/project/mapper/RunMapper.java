package pl.project.mapper;

import org.springframework.stereotype.Component;
import pl.project.entity.Run;
import pl.project.entity.dtos.RunDTO;
import pl.project.utils.mapper.Mapper;

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
