package com.alex.multithreading.application;

import com.alex.multithreading.exception.OutOfRangeException;

/**
 * Class whose single responsibility is
 * to handle exceptions at the application level
 *
 */
public final class ApplicationExceptionHandler extends AbstractExceptionHandler {

    /**
     * Handle the exceptions caught at the application level
     *
     * @param exception      the Exception to handle
     * @param userInterface  the UserInterface to display error messages
     */
    @Override
    public void handle(Exception exception, UserInterface userInterface) {

        if (exception instanceof OutOfRangeException)
            userInterface.displayError("Error. Only positive integers please.");

        else
            throw new IllegalArgumentException("Could not handle exception", exception);

    }

}
