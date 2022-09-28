package com.alex.multithreading.common;

import com.alex.multithreading.exception.EmptyInputException;
import com.alex.multithreading.exception.OutOfRangeException;

import java.util.List;

import static com.alex.multithreading.common.ArraysUtil.isEmpty;
import static java.lang.String.format;

/**
 * Class whose single responsibility is
 * to assert assumptions
 *
 * @author Alex Angulo
 */
public final class Assert {

    /**
     * Assert that an array is not empty
     *
     * @param array   the array
     */
    public static <T> void notEmpty(T[] array) {
        if (isEmpty(array))
            throw new EmptyInputException();
    }

    /**
     * Assert that an integer is greater than a certain number
     *
     * @param integer the tested integer
     * @throws OutOfRangeException if the tested integer is not greater than the other number
     */
    public static void isGreaterThan(int floor, int integer) throws OutOfRangeException {
        if (integer <= floor)
            throw new OutOfRangeException();
    }


    /**
     * Assert that all the integers of a list are positive
     *
     * @param integers the tested integers
     */
    public static void allGreaterThan(int floor, List<Integer> integers) {
        integers.forEach(integer -> Assert.isGreaterThan(floor, integer));
    }
}
