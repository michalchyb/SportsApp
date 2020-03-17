package pl.project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "runs")
public class Run {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
