package pl.project.models.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TriathlonDTO {

    private String nameRun;
    private double distance = 0.0;
    private Date date;
    private String myTime;
    private String city;
    private String swimTime;
    private String t1;
    private String bikeTime;
    private String t2;
    private String runTime;
}
