package org.example.soccerplayerscatalog30.exception;

import org.example.soccerplayerscatalog30.exception.custom.CustomEntityExistException;
import org.example.soccerplayerscatalog30.exception.custom.CustomNotExistException;
import org.example.soccerplayerscatalog30.exception.custom.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Класс, служащий для обработки возникающих ошибок
 */
@ControllerAdvice
public class CustomExceptionHandler extends BaseControllerAdvice {

    /**
     * Основной обработчик валидации.
     * Отлавливает и обрабатывает все ошибки связанные с входящей валидацией данных.
     *
     * @param exception ошибка валидации
     * @param request   данные HTTP запроса
     * @return удобочитаемый JSON с описанием ошибки
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleDtoValidatingException(MethodArgumentNotValidException exception,
                                                                            WebRequest request) {
        List<ValidationError> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fields -> new ValidationError(
                                fields.getField(),
                                fields.getDefaultMessage()
                        )
                )
                .toList();

        String url = getUrl(request);

        return new ResponseEntity<>(
                new CustomErrorResponse()
                        .setStatus(HttpStatus.BAD_REQUEST)
                        .setUrl(url)
                        .setTimestamp(LocalDateTime.now())
                        .setValidationErrors(validationErrors),
                HttpStatus.BAD_REQUEST
        );
    }

    /**
     * Отлавливает ошибки, связанные с отсутствием искомого объекта
     *
     * @param exception  возникает при отсутствии искомой сущности в бд
     * @param webRequest http запрос
     * @return HTTP Status код и JSON с ответом ({@link ResponseEntity})
     */
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
                HttpStatus.NOT_FOUND
        );
    }

    /**
     * Отлавливает ошибки связанные с попыткой добавить сущность/данные в сущность,
     * которые уже существуют в бд и/или помечены как unique.
     *
     * @param exception  возникает при конфликтах сущностей в бд
     * @param webRequest http запрос
     * @return HTTP Status код и JSON с ответом ({@link ResponseEntity})
     */
    @ExceptionHandler(CustomEntityExistException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomEntityExistException(
            CustomEntityExistException exception,
            WebRequest webRequest
    ) {
        return new ResponseEntity<>(
                new CustomErrorResponse()
                        .setTimestamp(LocalDateTime.now())
                        .setMessage(exception.getMessage())
                        .setStatus(HttpStatus.CONFLICT)
                        .setUrl(getUrl(webRequest)),
                HttpStatus.CONFLICT
        );
    }
}
