package pl.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RunNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(RunNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String runNotFoundController(RunNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(RunsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String runsNotFoundController(RunsNotFoundException ex ){
        return ex.getMessage();
    }
}
