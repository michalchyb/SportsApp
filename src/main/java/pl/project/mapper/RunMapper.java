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
