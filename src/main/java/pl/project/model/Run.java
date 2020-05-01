package pl.project.model;

import lombok.*;
import pl.project.model.timestamp.AbstractTimestampEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "runs")
public class Run extends AbstractTimestampEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name_run")
    private String name;
    @Column(name = "distance")
    private double distance;
    @Column(name = "date")
    private Date date;
    @Column(name = "my_time")
    private String time;
    @Column(name = "city")
    private String city;
}
