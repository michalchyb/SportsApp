package pl.project.exception;

public class RunNotFoundByIdException extends RuntimeException {
    public RunNotFoundByIdException(Long id) {
        super("The run with id : " + id + " is not found");
    }
}
