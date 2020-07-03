package pl.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;


@ControllerAdvice
@Slf4j
public class ExceptionHandlers extends BaseExceptionHandler {

    public ExceptionHandlers() {
        super(log);
    }

    @ResponseBody
    @ExceptionHandler(RunNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRunNotFoundController(final RunNotFoundException ex) {
        log.error("Run not found thrown", ex);
        return new ErrorResponse(LocalDateTime.now(), "RUN_NOT_FOUND", HttpStatus.NOT_FOUND.value(), ex.getMessage());

    }

    @ResponseBody
    @ExceptionHandler(RunsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRunsNotFoundController(final RunsNotFoundException ex) {
        log.error("Runs not found thrown", ex);
        return new ErrorResponse(LocalDateTime.now(), "RUNS_NOT_FOUND", HttpStatus.NOT_FOUND.value(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(RunNotFoundByIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRunNotFoundByIdExceptionController(final RunNotFoundByIdException ex) {
        log.error("Run with given id not found");
        return new ErrorResponse(LocalDateTime.now(), "RUN_WITH_ID_NOT_FOUND", HttpStatus.NOT_FOUND.value(), ex.getMessage());

    }

    @ResponseBody
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ErrorResponse handleMaxUploadSizeExceededExceptionController(final MaxUploadSizeExceededException ex) {
        log.error("File is too large");
        return new ErrorResponse(LocalDateTime.now(), "EXPECTATION_FAILED", HttpStatus.EXPECTATION_FAILED.value(), ex.getMessage());

    }

    @ResponseBody
    @ExceptionHandler(ExtensionError.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse handleExtensionError(final ExtensionError ex) {
        log.error("Extension error");
        return new ErrorResponse(LocalDateTime.now(), "EXTENSION_ERROR", HttpStatus.NOT_ACCEPTABLE.value(), ex.getMessage());

    }
}
