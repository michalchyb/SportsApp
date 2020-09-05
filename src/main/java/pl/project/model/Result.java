package pl.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import javax.persistence.*;

@JsonDeserialize(builder = Result.Builder.class)
@Entity(name = "result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private final String swim;
    private final String t1;
    private final String bike;
    private final String t2;
    private final String run;
    private final String sum;

    @OneToOne(mappedBy = "result")
    private Tri tri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Result(Builder builder) {
        swim = builder.swim;
        t1 = builder.t1;
        bike = builder.bike;
        t2 = builder.t2;
        run = builder.run;
        sum = builder.sum;

    }

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder {


        String swim = "-";
        String t1 = "-";
        String bike = "-";
        String t2 = "-";
        String run = "-";

        final String sum;

        public Builder(@JsonProperty("sum") String sum) {
            this.sum = sum;
        }

        public Builder swim(String swim) {
            this.swim = swim;
            return this;
        }

        public Builder t1(String t1) {
            this.t1 = t1;
            return this;
        }

        public Builder bike(String bike) {
            this.bike = bike;
            return this;
        }

        public Builder t2(String t2) {
            this.t2 = t2;
            return this;
        }

        public Builder run(String run) {
            this.run = run;
            return this;
        }

        public Result build() {
            return new Result(this);
        }

    }
}
