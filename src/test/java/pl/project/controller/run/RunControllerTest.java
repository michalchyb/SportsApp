package pl.project.controller.run;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import pl.project.exception.RunsNotFoundException;
import pl.project.model.Run;
import pl.project.service.RunService;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RunControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RunService runService;

    @Value("${test.authorization.token}")
    private String token;

    @Test
    public void getRunsTestCorrectValues() throws Exception {

        List<Run> list = prepareRunList();
        when(runService.getRuns()).thenReturn(list);

        mvc.perform(get("/api/runs")
                .header("Authorization", token)
                .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0]").exists())
                .andExpect(jsonPath("$[0]").isNotEmpty())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[1]").exists())
                .andExpect(jsonPath("$[1]").isNotEmpty())
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[2]").doesNotExist());
    }

    @Test
    public void getRunsTestRunsNotFoundException() throws Exception {
        given(runService.getRuns()).willThrow(new RunsNotFoundException());

        mvc.perform(get("/api/runs")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


    private List<Run> prepareRunList() {
        List<Run> runList = new ArrayList<>();
        Run run1 = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:40", "Warszawa");
        Run run2 = prepareRun(2L, "Maniacka 10", 10.0, new Date(2020, Calendar.APRIL, 22), "54:90", "Poznań ");
        runList.add(run1);
        runList.add(run2);
        return runList;
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

