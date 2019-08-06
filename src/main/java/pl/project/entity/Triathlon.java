package pl.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Triathlon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @NotNull
    @Size(min = 5)
    private String nameRun;
    @NotNull
    @Positive
    private double distance = 0.0;
    private Date date;
    private String myTime;
    @NotEmpty
    @NotNull
    @Size(min = 3)
    private String city;
    private String swimTime;
    private String t1;
    private String bikeTime;
    private String t2;
    private String runTime;

    public Triathlon() {
    }

    ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameRun() {
        return nameRun;
    }

    public void setNameRun(String nameRun) {
        this.nameRun = nameRun;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMyTime() {
        return myTime;
    }

    public void setMyTime(String myTime) {
        this.myTime = myTime;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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

    public Triathlon(long id, @NotEmpty @NotNull @Size(min = 5) String nameRun, @NotNull @Positive double distance, Date date, String myTime, @NotEmpty @NotNull @Size(min = 3) String city, String swimTime, String t1, String bikeTime, String t2, String runTime) {
        this.id = id;
        this.nameRun = nameRun;
        this.distance = distance;
        this.date = date;
        this.myTime = myTime;
        this.city = city;
        this.swimTime = swimTime;
        this.t1 = t1;
        this.bikeTime = bikeTime;
        this.t2 = t2;
        this.runTime = runTime;
    }

    @Override
    public String toString() {
        return "Triathlon{" +
                "id=" + id +
                ", nameRun='" + nameRun + '\'' +
                ", distance=" + distance +
                ", date=" + date +
                ", myTime='" + myTime + '\'' +
                ", city='" + city + '\'' +
                ", swimTime='" + swimTime + '\'' +
                ", t1='" + t1 + '\'' +
                ", bikeTime='" + bikeTime + '\'' +
                ", t2='" + t2 + '\'' +
                ", runTime='" + runTime + '\'' +
                '}';
    }
}