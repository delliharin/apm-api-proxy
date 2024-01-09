package com.emc.cm.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(final String message) {
        super(message);
    }
}
