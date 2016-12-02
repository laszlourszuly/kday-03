package com.echsylon.recipe.network.exception;

/**
 * This class is responsible for delivering a network connection related runtime exception.
 */
public class NoConnectionException extends RuntimeException {

    public NoConnectionException(Throwable cause) {
        super(cause);
    }

}
