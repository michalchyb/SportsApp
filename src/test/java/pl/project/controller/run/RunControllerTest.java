package pl.project.controller.run;

import com.fasterxml.jackson.databind.ObjectMapper;
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
import pl.project.model.dto.RunDTO;
import pl.project.service.RunService;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RunControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RunService runService;

    @Value("${test.authorization.token}")
    private String token;

    @Test
    public void test_get_all_runs_success() throws Exception {

        List<Run> list = prepareRunList();
        when(runService.getRuns(0)).thenReturn(list);

        mvc.perform(get("/api/runs ")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
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
    public void test_get_all_runs_fail_404_runs_not_found() throws Exception {
        given(runService.getRuns(0)).willThrow(new RunsNotFoundException());

        mvc.perform(get("/api/runs")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void test_get_run_by_id_success() throws Exception {
        Run run = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:40", "Warszawa");
        when(runService.getRunById(1L)).thenReturn(run);

        mvc.perform(get("/api/run/{id}", 1)
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Biegnij Warszawo"))
                .andExpect(status().isOk());
        verify(runService, times(1)).getRunById(1L);


    }

    @Test
    public void test_create_run_success() throws Exception {
        RunDTO runDTO = new RunDTO(1L, "Biegnij Warszawo", 5.0, new Date(2000, Calendar.APRIL, 21), "00:27:40", "Warszawa");
        mvc.perform(post("/api/dto/runs")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(runDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void test_create_run_fail_400_bad_request() throws Exception {
        RunDTO runDTO = new RunDTO(1L, "Biegnij Warszawo", 5.0, new Date(2000, Calendar.APRIL, 21), "00:27:4s", "Warszawa");

        mvc.perform(post("/api/dto/runs")
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(runDTO)))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void test_delete_user_success() throws Exception {
        Run run = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:40", "Warszawa");

        when(runService.getRunById(1L)).thenReturn(run);
        doNothing().when(runService).deleteRunById(run.getId());

        mvc.perform(delete("/api/dto/runs/{id}", run.getId())
                .header("Authorization", token)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(runService, times(1)).deleteRunById(run.getId());
        verifyNoMoreInteractions(runService);

    }

    private List<Run> prepareRunList() {
        List<Run> runList = new ArrayList<>();
        Run run1 = prepareRun(1L, "Biegnij Warszawo", 5.0, new Date(2020, Calendar.APRIL, 21), "27:40", "Warszawa");
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

