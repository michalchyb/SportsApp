package pl.project.exception;

public class RunsNotFoundException extends RuntimeException {
    public RunsNotFoundException() {
        super("Could not find any runs");
    }
}
