package pl.project.mapper;

import org.springframework.stereotype.Component;
import pl.project.common.mapper.Mapper;
import pl.project.model.Triathlon;
import pl.project.model.dto.TriathlonDTO;

@Component
public class TriathlonMapper implements Mapper<Triathlon, TriathlonDTO> {

    @Override
    public TriathlonDTO map(Triathlon from) {
        return TriathlonDTO
                .builder()
                .nameRun(from.getNameRun())
                .distance(from.getDistance())
                .date(from.getDate())
                .myTime(from.getMyTime())
                .city(from.getCity())
                .swimTime(from.getSwimTime())
                .t1(from.getT1())
                .bikeTime(from.getBikeTime())
                .t2(from.getT2())
                .runTime(from.getRunTime())
                .build();
    }

    @Override
    public Triathlon reverseMap(TriathlonDTO to) {
        return Triathlon.builder()
                .nameRun(to.getNameRun())
                .distance(to.getDistance())
                .date(to.getDate())
                .myTime(to.getMyTime())
                .city(to.getCity())
                .swimTime(to.getSwimTime())
                .t1(to.getT1())
                .bikeTime(to.getBikeTime())
                .t2(to.getT2())
                .runTime(to.getRunTime())
                .build();
    }
}
