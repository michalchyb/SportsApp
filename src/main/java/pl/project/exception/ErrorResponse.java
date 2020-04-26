package pl.project.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
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
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> errors = new ArrayList<>();
    private final int statusCode;
    private final String message;


    public ErrorResponse(LocalDateTime timeStamp, String code, int statusCode, String message) {
        this.timeStamp = timeStamp;
        this.code = code;
        this.statusCode = statusCode;
        this.message = message;
    }

    public ErrorResponse(LocalDateTime timeStamp, String code, List<String> errors, int statusCode, String message) {
        this.timeStamp = timeStamp;
        this.code = code;
        this.errors = errors;
        this.statusCode = statusCode;
        this.message = message;
    }
}