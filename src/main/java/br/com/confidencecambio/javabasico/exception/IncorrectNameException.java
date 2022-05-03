package br.com.confidencecambio.javabasico.exception;

public class IncorrectNameException extends Exception{

    public IncorrectNameException(String errorMessage) {
        super(errorMessage);
    }
}