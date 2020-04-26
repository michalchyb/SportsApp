package pl.project.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.constraints.*;
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

    @NotNull(message = "Distance can not be null")
    @DecimalMax(
            value = "42.195",
            message = "Distance should be lower then {value}")
    @DecimalMin(
            value = "0.0",
            message = "Distance should be bigger then {value}")
    private Double distance;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date can not be null")
    private Date date;

    @NotNull(message = "Time can not be null")
    @Pattern(regexp = "^\\d{2}:\\d{2}:\\d{2}$")
    private String time;

    @NotBlank(message = "City can not be empty")
    @NotNull(message = "City can not be null")
    @Pattern(regexp = "^[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$")
    private String city;
}
