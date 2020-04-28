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
    public void test_map() {
        //given
        Run run = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:40", "Warszawa");

        //when
        RunDTO runDTO = runMapper.map(run);

        //then
        assertThat(runDTO).hasFieldOrPropertyWithValue("name", "Biegnij Warszawo");
        assertThat(runDTO).hasFieldOrPropertyWithValue("distance", 5.0);
        assertThat(runDTO).hasFieldOrPropertyWithValue("date", new Date(2020, Calendar.APRIL, 21));
        assertThat(runDTO).hasFieldOrPropertyWithValue("time", "27:40");
        assertThat(runDTO).hasFieldOrPropertyWithValue("city", "Warszawa");

    }

    @Test
    public void test_reverse_map() {
    }

    private Run prepareRun(Long id, String name, double distance, Date date, String time, String city) {
        return Run.builder()
                .id(id)
                .name(name)
                .distance(distance)
                .date(date)
                .time(time)
                .city(city)
                .build();
    }
}