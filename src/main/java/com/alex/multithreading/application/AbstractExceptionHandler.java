package com.alex.multithreading.application;

/**
 * Abstract representation of an Exception Handler
 */
public abstract class AbstractExceptionHandler {

    /**
     * Handles an exception
     *
     * @param  exception      the exception to handle
     * @param  userInterface  the user interface to display error messages (if needed)
     */
    protected abstract void handle(Exception exception, UserInterface userInterface);

}
