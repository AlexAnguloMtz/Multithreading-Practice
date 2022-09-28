package com.alex.multithreading;

import com.alex.multithreading.application.FactorialCalculationApplication;
import com.alex.multithreading.application.UserInterface;
import com.alex.multithreading.cli.CommandLineUserInterface;
import com.alex.multithreading.common.Assert;

import java.util.List;

import static com.alex.multithreading.common.ArraysUtil.toIntegerList;

/**
 * Requirements:
 *
 *  1. Parse all the command line arguments as Integers
 *  2. For each Integer, create a new object of a custom Runnable implementation class
 *     that takes said Integer in its constructor
 *  3. For each Runnable object, create a new Thread and call run()
 *  4. Each of these Threads should do two things:
 *
 *     A) Display the name of the Thread
 *     B) Display the factorial of the integer received in the custom Runnable object's constructor
 *
 */
public class Main {

    private static final UserInterface USER_INTERFACE = new CommandLineUserInterface();

    /**
     * Bootstrap the application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            run(args);
        } catch (Exception exception) {
            handle(exception);
        }
    }

    private static void run(String[] strings) {
        Assert.notEmpty(strings);
        List<Integer> integers = toIntegerList(strings);
        Assert.allGreaterThan(0, integers);
        integers.forEach(integer -> runAppInNewThreadWith(integer));
    }

    private static void runAppInNewThreadWith(Integer integer) {
        FactorialCalculationApplication application = new FactorialCalculationApplication(integer, USER_INTERFACE);
        new Thread(application).start();
    }

    private static void handle(Exception exception) {
        new MainExceptionHandler().handle(exception, USER_INTERFACE);
    }

}