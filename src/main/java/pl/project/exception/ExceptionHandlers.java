package pl.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
        return new ErrorResponse(LocalDateTime.now(), "RUN_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND.value());

    }

    @ResponseBody
    @ExceptionHandler(RunsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String runsNotFoundController(RunsNotFoundException ex) {
        return ex.getMessage();
    }

}
