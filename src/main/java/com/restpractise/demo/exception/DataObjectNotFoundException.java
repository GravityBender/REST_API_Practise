package com.restpractise.demo.exception;

public class DataObjectNotFoundException extends RuntimeException{

    public DataObjectNotFoundException() {
        super();
    }
    public DataObjectNotFoundException(String message, Throwable clause) {
        super(message, clause);
    }

    public DataObjectNotFoundException(String message) {
        super(message);
    }

    public DataObjectNotFoundException(Throwable clause) {
        super(clause);
    }

}
