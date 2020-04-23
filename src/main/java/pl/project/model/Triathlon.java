package pl.project.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Triathlon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_run")
    @NotEmpty
    private String nameRun;
    @Column(name = "distance")
    @NotEmpty
    private double distance = 0.0;
    @Column(name = "date")
    @NotEmpty
    private Date date;
    @Column(name = "time")
    @NotEmpty
    private String time;
    @Column(name = "city")
    @NotEmpty
    private String city;
    @Column(name = "swim_time")
    @NotEmpty
    private String swimTime;
    @Column(name = "t1")
    @NotEmpty
    private String t1;
    @Column(name = "bike_time")
    @NotEmpty
    private String bikeTime;
    @Column(name = "t2name_run")
    @NotEmpty
    private String t2;
    @Column(name = "run_time")
    @NotEmpty
    private String runTime;
}