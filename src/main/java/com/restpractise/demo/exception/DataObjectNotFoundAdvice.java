package com.restpractise.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DataObjectNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(DataObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String dataObjectNotFoundHandler(DataObjectNotFoundException exception) {
        return exception.getMessage();
    }

}
