package pl.project.service;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.project.exception.RunsNotFoundException;
import pl.project.model.Run;
import pl.project.repository.RunRepository;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RunServiceTest {

    @Mock
    private RunRepository runRepository;

    @InjectMocks
    RunService runService;

    @Test
    public void test_get_run_by_id() {
        Run dummyRun = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "54:90", "Warszawa");

        when(runRepository.findById(1L)).thenReturn(Optional.ofNullable(dummyRun));
        Run run = runService.getRunById(1L);

        assertEquals("Warszawa", run.getCity());
        assertEquals("54:90", run.getTime());
        assertEquals(5.0, run.getDistance(), 0);
    }


    @Test
    public void test_get_all_runs() {
        List<Run> list = prepareRunList();
        when(runRepository.findAll()).thenReturn(list);

        List<Run> runsList = runService.getRuns(0);

        Assertions.assertEquals(2, runsList.size());
        verify(runRepository, times(1)).findAll();
    }

    @Test
    public void test_get_runs_throw_exception() {
        List<Run> list = new ArrayList<>();

        when(runRepository.findAll()).thenReturn(list);

        Assertions.assertThrows(RunsNotFoundException.class, () -> runService.getRuns(0));

    }

    private List<Run> prepareRunList() {
        List<Run> runList = new ArrayList<>();
        Run run1 = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:400", "Warszawa");
        Run run2 = prepareRun(2L, "Maniacka 10", 10.0, new Date(2020, Calendar.APRIL, 22), "54:90", "Poznań ");
        runList.add(run1);
        runList.add(run2);
        return runList;
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