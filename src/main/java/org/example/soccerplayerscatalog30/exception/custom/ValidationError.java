package org.example.soccerplayerscatalog30.exception.custom;

public class ValidationError {
    private String field;
    private String message;

    public ValidationError(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public ValidationError setField(String field) {
        this.field = field;
        return this;
    }

    public ValidationError setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}

