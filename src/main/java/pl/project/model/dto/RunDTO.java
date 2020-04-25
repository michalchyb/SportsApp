package pl.project.model.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RunDTO {

    @NotBlank(message = "Name can not be empty")
    @NotNull(message = "Name can not be null")
    private String name;
    private double distance;
    private Date date;
    private String time;
    @NotBlank(message = "City can not be empty")
    @NotNull(message = "City can not be null")
    private String city;
}
