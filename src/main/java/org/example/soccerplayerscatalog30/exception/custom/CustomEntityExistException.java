package org.example.soccerplayerscatalog30.exception.custom;

/**
 * Ошибка, отвечающая за случаи конфликтов сущностей в бд
 */
public class CustomEntityExistException extends RuntimeException {
    public CustomEntityExistException(String message) {
        super(message);
    }
}
