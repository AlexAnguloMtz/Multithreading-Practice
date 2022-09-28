package com.alex.multithreading.application;


import com.alex.multithreading.factorial.Factorial;

import static java.lang.String.format;
import static java.lang.Thread.currentThread;
import static java.util.Objects.requireNonNull;

/**
 *  Runnable implementation that displays a 'Hello Thread' message
 *  with the name of the current Thread, and also the factorial
 *  of the integer received in the constructor.
 *
 *  @author Alex Angulo
 */
public class FactorialCalculationApplication implements Runnable {

    private static final String HELLO_THREAD = "Hello from Thread: %s";
    private static final String FACTORIAL_RESULT_MESSAGE = "Factorial(%d) = %d";
    private static final String MESSAGE_TEMPLATE = format("%s, %s", HELLO_THREAD, FACTORIAL_RESULT_MESSAGE);

    private final int integer;
    private final UserInterface userInterface;

    public FactorialCalculationApplication(int integer, UserInterface userInterface) {
        this.integer = integer;
        this.userInterface = requireNonNull(userInterface);
    }

    /**
     *  Display the name of the current Thread
     *  and the factorial of the integer received
     *  in the constructor
     */
    @Override
    public void run() {
        try {
            display(messageFor(integer));
        } catch (Exception exception) {
            handle(exception);
        }
    }

    private String messageFor(int integer) {
        return format(MESSAGE_TEMPLATE, threadName(), integer, Factorial.of(integer));
    }

    private String threadName() {
        return currentThread().getName();
    }

    private void handle(Exception exception) {
        new ApplicationExceptionHandler().handle(exception, userInterface);
    }

    private void display(String message) {
        userInterface.displayMessage(message);
    }

}