package pl.project.exception;

public class RunNotFoundException extends RuntimeException {
    public RunNotFoundException(Long id) {
        super("Could not find run " + id);
    }
}
