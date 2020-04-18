package pl.project.exception;

public class RunsNotFoundException extends RuntimeException {
    public RunsNotFoundException() {
        super("Runs not found");
    }
}
