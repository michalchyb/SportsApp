package pl.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Triathlon extends Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    private String swimTime;
    private String t1;
    private String bikeTime;
    private String t2;
    private String runTime;

    public Triathlon() { };

    public Triathlon(String nameRun, double distance, Date date, String myTime, String city, long id, String swimTime, String t1, String bikeTime, String t2, String runTime) {
        super(nameRun, distance, date, myTime, city);
        this.id = id;
        this.swimTime = swimTime;
        this.t1 = t1;
        this.bikeTime = bikeTime;
        this.t2 = t2;
        this.runTime = runTime;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getSwimTime() {
        return swimTime;
    }

    public void setSwimTime(String swimTime) {
        this.swimTime = swimTime;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getBikeTime() {
        return bikeTime;
    }

    public void setBikeTime(String bikeTime) {
        this.bikeTime = bikeTime;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getRunTime() {
        return runTime;
    }

    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
}