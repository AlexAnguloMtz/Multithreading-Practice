package com.alex.multithreading.cli;

import com.alex.multithreading.application.UserInterface;

/**
 * Command line implementation of a user interface
 */
public class CommandLineUserInterface implements UserInterface {
    /**
     * Print a message to the standard output
     *
     * @param message   the message to print
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Print an error to the standard output
     *
     * @param error the error to print
     */
    @Override
    public void displayError(String error) {
        System.err.println(error);
    }
}
