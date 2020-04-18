package pl.project.mapper;

import org.junit.Before;
import org.junit.Test;
import pl.project.model.Run;
import pl.project.model.dto.RunDTO;

import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class RunMapperTest {

    private RunMapper runMapper;

    @Before
    public void setup() {
        runMapper = new RunMapper();
    }

    @Test
    public void map() {
        //given
        Run run = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:40", "Warszawa");

        //when
        RunDTO runDTO = runMapper.map(run);

        //then
        assertThat(runDTO).hasFieldOrPropertyWithValue("nameRun", "Biegnij Warszawo");
        assertThat(runDTO).hasFieldOrPropertyWithValue("distance", 5.0);
        assertThat(runDTO).hasFieldOrPropertyWithValue("date", new Date(2020, Calendar.APRIL, 21));
        assertThat(runDTO).hasFieldOrPropertyWithValue("myTime", "27:40");
        assertThat(runDTO).hasFieldOrPropertyWithValue("city", "Warszawa");

    }

    @Test
    public void reverseMap() {
    }

    private Run prepareRun(Long id, String name, double distance, Date date, String myTime, String city) {
        return Run.builder()
                .id(id)
                .nameRun(name)
                .distance(distance)
                .date(date)
                .myTime(myTime)
                .city(city)
                .build();
    }
}