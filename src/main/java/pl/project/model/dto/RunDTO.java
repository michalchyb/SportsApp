package pl.project.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RunDTO {

    private String name;
    private double distance;
    private Date date;
    private String time;
    private String city;
}
