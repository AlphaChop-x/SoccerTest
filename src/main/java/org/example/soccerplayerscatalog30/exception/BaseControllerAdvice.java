package org.example.soccerplayerscatalog30.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BaseControllerAdvice {
    protected String getUrl(WebRequest request) {
        return request.getDescription(false).replace("uri=", "");
    }
}
