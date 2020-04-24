package pl.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionHandler extends BaseExceptionHandler {

    public ExceptionHandler() {
        super(log);
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(RunNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRunNotFoundController(final RunNotFoundException ex) {
        log.error("Run not found thrown", ex);
        return new ErrorResponse(LocalDateTime.now(), "RUN_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND.value());

    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(RunsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleRunsNotFoundController(final RunsNotFoundException ex) {
        log.error("Runs not found thrown", ex);
        return new ErrorResponse(LocalDateTime.now(), "RUNS_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        log.error("Bad request", ex);
        return new ErrorResponse(LocalDateTime.now(), "BAD_REQUEST", ex.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
}
