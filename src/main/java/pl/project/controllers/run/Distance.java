package pl.project.controllers.run;

public enum Distance {

    FIVE(5),
    TEN(10),
    HALFMARATHON(21),
    MARATHON(42);

    private int runDistance;

    Distance(int runDistance) {
        this.runDistance = runDistance;
    }

    public int getDistance() {
        return runDistance;
    }
}
