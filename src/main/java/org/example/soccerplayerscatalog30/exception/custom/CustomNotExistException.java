package org.example.soccerplayerscatalog30.exception.custom;

/**
 * Ошибка, отвечающая за случаи отсутствия искомой сущности в бд
 */
public class CustomNotExistException extends RuntimeException {
    public CustomNotExistException(String message) {
        super(message);
    }
}
