package pl.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    private String nameRun;
    @Column(name = "distance")
    private double distance = 0.0;
    @Column(name = "date")
    private Date date;
    @Column(name = "my_time")
    private String myTime;
    @Column(name = "city")
    private String city;
    @Column(name = "swim_time")
    private String swimTime;
    @Column(name = "t1")
    private String t1;
    @Column(name = "bike_time")
    private String bikeTime;
    @Column(name = "t2name_run")
    private String t2;
    @Column(name = "run_time")
    private String runTime;
}