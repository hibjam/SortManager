package com.sparta.jh.exceptions;

public class IncorrectSelectException extends Exception{
    private final String message;

    public IncorrectSelectException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {return message;}

}
