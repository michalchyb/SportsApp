package pl.project.exception;

public class TrisNotFoundException extends RuntimeException {
    public TrisNotFoundException() {
        super("Triathlons not found");
    }
}
