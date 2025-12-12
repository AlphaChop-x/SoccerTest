package org.example.soccerplayerscatalog30.exception;

import org.example.soccerplayerscatalog30.exception.custom.ValidationError;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс ответа с ошибкой
 */
public class CustomErrorResponse {
    /**
     * Время выброса ошибки
     */
    private LocalDateTime timestamp;
    /**
     * Http статус ошибки
     */
    private HttpStatus status;
    /**
     * Сообщение ошибки
     */
    private String message;
    /**
     * Эндпоинт вернувший ошибку
     */
    private String url;
    /**
     * Ошибки валидации
     */
    private List<ValidationError> validationErrors;

    public CustomErrorResponse(LocalDateTime timestamp, HttpStatus status, String message, String url, List<ValidationError> validationErrors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.url = url;
        this.validationErrors = validationErrors;
    }

    public CustomErrorResponse() {
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public CustomErrorResponse setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public CustomErrorResponse setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public CustomErrorResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public CustomErrorResponse setUrl(String url) {
        this.url = url;
        return this;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public CustomErrorResponse setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
        return this;
    }
}
