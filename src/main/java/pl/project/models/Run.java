package pl.project.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;


@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_run")
    @NotEmpty
    @Size(min=2, max=30)
    private String nameRun;
    @Column(name = "distance")
    @NotEmpty
    private double distance;
    @Column(name = "date")
    @NotEmpty
    private Date date;
    @Column(name = "my_time")
    @NotEmpty
    private String myTime;
    @Column(name = "city")
    @NotEmpty
    private String city;


}
