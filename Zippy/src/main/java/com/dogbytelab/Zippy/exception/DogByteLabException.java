package com.dogbytelab.Zippy.exception;

public class DogByteLabException extends RuntimeException {
    public DogByteLabException(String message) {
        super(message);
    }

    public DogByteLabException(String message, Throwable cause) {
        super(message, cause);
    }
}
