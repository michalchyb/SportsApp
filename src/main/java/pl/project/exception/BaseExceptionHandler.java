package pl.project.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.slf4j.Logger;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseExceptionHandler {
    private final Logger log;

    protected BaseExceptionHandler(final Logger log) {
        this.log = log;
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
        return new ErrorResponse(LocalDateTime.now(), "BAD_REQUEST", errors, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleInvalidFormatException(final InvalidFormatException ex) {
        log.error("Request validation error", ex);
        return new ErrorResponse(LocalDateTime.now(), "BAD_REQUEST", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }


    @ResponseBody
    @ExceptionHandler(ConversionFailedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConversionFailedException(final ConversionFailedException ex) {
        log.error("Bad sorting properties", ex);
        return new ErrorResponse(LocalDateTime.now(), "BAD_REQUEST", HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }
}
