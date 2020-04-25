package pl.project.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


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
    public ErrorResponse handleRunsNotFoundController(final RunsNotFoundException ex) {
        log.error("Runs not found thrown", ex);
        return new ErrorResponse(LocalDateTime.now(), "RUNS_NOT_FOUND", ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        log.error("Request validation error", ex);
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        return new ErrorResponse(LocalDateTime.now(), "BAD_REQUEST", ex.getMessage(), errors, HttpStatus.BAD_REQUEST.value());
    }
}
