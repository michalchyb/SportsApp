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
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name_run")
    private String nameRun;
    @Column(name = "distance")
    private double distance;
    @Column(name = "date")
    private Date date;
    @Column(name = "my_time")
    private String myTime;
    @Column(name = "city")
    private String city;


}
