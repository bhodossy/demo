package com.example.demo.backend.publication;

public class PublicationException extends Exception{

    public PublicationException() {
    }

    public PublicationException(String message) {
        super(message);
    }

    public PublicationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PublicationException(Throwable cause) {
        super(cause);
    }

}
