package pl.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Run {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nameRun;
    private double distance;
    private Date date;
    private String myTime;
    private String city;

    public static final class Builder {

        private long id;
        private String nameRun;
        private double distance;
        private Date date;
        private String myTime;
        private String city;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder distance(double distance) {
            this.distance = distance;
            return this;
        }
        public Builder nameRun(String nameRun) {
            this.nameRun = nameRun;
            return this;
        }
        public Builder date(Date date) {
            this.date = date;
            return this;
        }
        public Builder myTime(String myTime) {
            this.myTime = myTime;
            return this;
        }
        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Run build(){
            Run run = new Run();
            run.id = this.id;
            run.nameRun = this.nameRun;
            run.distance = this.distance;
            run.date = this.date;
            run.myTime = this.myTime;
            run.city = this.city;

            return run;
        }
    }
}
