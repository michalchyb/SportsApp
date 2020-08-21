package pl.project.model;

public enum Distance {
    EIGHTIRONMAN(28.25),
    SPRINT(25.75),
    OLYMPIC(51.5),
    QUARTER(56.5),
    HALFIRONMAN(112.9),
    IRONMAN(225.8);

    private final double distance;

    Distance(double distance) {
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }
}
