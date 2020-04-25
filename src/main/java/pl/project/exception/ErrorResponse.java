package pl.project.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Builder
class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private final LocalDateTime timeStamp;
    private final String code;
    private final String message;
    private List<String> errors = new ArrayList<>();
    private final int statusCode;


    ErrorResponse(LocalDateTime timeStamp, String code, String message, List<String> errors, int statusCode) {
        this.timeStamp = timeStamp;
        this.code = code;
        this.message = message;
        this.errors = errors;
        this.statusCode = statusCode;
    }


    ErrorResponse(LocalDateTime timeStamp, String code, String message, int statusCode) {
        this.timeStamp = timeStamp;
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}