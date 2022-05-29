package com.blog.blogSite.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;
    @Value(value = "${data.exception.message3}")
    private String message3;
    @Value(value = "${data.exception.message4}")
    private String message4;

    @ExceptionHandler(value = ResourceAlreadyExists.class)
    public ResponseEntity resourceAlreadyExistsException(ResourceAlreadyExists resourceAlreadyExists) {
        return new ResponseEntity(message1, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
        return new ResponseEntity(message2, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>(message3, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity authenticationFailsException(AuthenticationException exception) {
        return new ResponseEntity<>(message4, HttpStatus.UNAUTHORIZED);
    }
}
