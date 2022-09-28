package com.alex.multithreading;

import com.alex.multithreading.exception.EmptyInputException;
import com.alex.multithreading.application.UserInterface;
import com.alex.multithreading.application.AbstractExceptionHandler;
import com.alex.multithreading.exception.OutOfRangeException;

/**
 * Class whose single responsibility is
 * to handle exceptions at the main method level
 *
 */
class MainExceptionHandler extends AbstractExceptionHandler {

    /**
     *  Handle the exceptions caught at the main method level.
     *  After handling the exception, the program will
     *  exit with an exit code different from 0.
     *
     * @param exception      the Exception to handle
     * @param userInterface  the UserInterface to display error messages
     */
    @Override
    public void handle(Exception exception, UserInterface userInterface) {

        if (exception instanceof EmptyInputException)
            exit(() -> userInterface.displayError("Error. No command line arguments found. Program aborted."));

        else if (exception instanceof NumberFormatException)
            exit(() -> userInterface.displayError("Error. This program accepts integers only. Program aborted."));

        else if (exception instanceof OutOfRangeException)
            exit(() -> userInterface.displayError("Error. Only positive integers please. Program aborted."));

        else
            throw new IllegalArgumentException("Could not handle exception", exception);

    }

    private void exit(Runnable runnable) {
        runnable.run();
        System.exit(1);
    }

}
