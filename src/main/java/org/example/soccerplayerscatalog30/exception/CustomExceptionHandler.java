package org.example.soccerplayerscatalog30.exception;

import org.example.soccerplayerscatalog30.exception.custom.CustomNotExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends BaseControllerAdvice {

    @ExceptionHandler(CustomNotExistException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomNotExistException(
            CustomNotExistException exception,
            WebRequest webRequest
    ) {
        return new ResponseEntity<>(
                new CustomErrorResponse()
                        .setTimestamp(LocalDateTime.now())
                        .setMessage(exception.getMessage())
                        .setStatus(HttpStatus.NOT_FOUND)
                        .setUrl(getUrl(webRequest)),
                HttpStatus.CONFLICT
        );
    }
}
