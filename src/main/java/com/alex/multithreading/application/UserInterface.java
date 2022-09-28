package com.alex.multithreading.application;

/**
 *  Abstraction for a user interface
 */
public interface UserInterface {

    /**
     * Displays a message
     *
     * @param message   the message to display
     */
    void displayMessage(String message);

    /**
     * Displays an error
     *
     * @param error   the error to display
     */
    void displayError(String error);

}
