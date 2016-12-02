package com.echsylon.recipe.network;


/**
 * This interface describes the asynchronous error listener callback.
 */
public interface ErrorListener {

    /**
     * Delivers an error to the implementing infrastructure.
     *
     * @param error The cause of the error.
     */
    void onError(Throwable error);

}