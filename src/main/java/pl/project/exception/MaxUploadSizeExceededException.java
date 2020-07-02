package pl.project.exception;

public class MaxUploadSizeExceededException extends RuntimeException {
    public MaxUploadSizeExceededException() {
        super("File is to large!");
    }
}
