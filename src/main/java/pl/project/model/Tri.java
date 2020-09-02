package pl.project.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tri")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "distance")
    private Distance distance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "result_id")
    private Result result;
}

