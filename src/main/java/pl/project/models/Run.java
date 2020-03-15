package pl.project.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
}
