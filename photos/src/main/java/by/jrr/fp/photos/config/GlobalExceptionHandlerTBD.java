package by.jrr.fp.photos.config;

import by.jrr.fp.photos.exceptions.EntityNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//todo
@ControllerAdvice
public class GlobalExceptionHandlerTBD extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = {EntityNotFoundException.class})
    protected ResponseEntity<Object> resolveEntityNotFoundException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Exceptions thrown in PhotoService";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
}
