package pl.project.exception;

public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(Long id) {
        super("The run with id " + id + " is not found");
    }
}
