package com.alex.multithreading.common;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

/**
 * Class whose single responsibility is to
 * provide utility methods for arrays
 *
 * @author Alex Angulo
 */

public final class ArraysUtil {

    /**
     * Transforms a String[] into a List<Integer>
     *
     * @param   strings    the strings to parse as integers
     * @return  a List<Integer> containing all the obtained Integers
     * @throws  NumberFormatException
     *          if any of the String objects in the original
     *          array cannot be parsed as a valid Integer
     */
    public static List<Integer> toIntegerList(String[] strings) throws NumberFormatException {
        return stream(strings)
                .map(Integer::parseInt)
                .collect(toList());
    }

    /**
     * Determines wheter an array is empty or not.
     *
     * @param array   the tested array
     * @return true if the array is empty, false otherwise
     */
    public static <T> boolean isEmpty(T[] array) {
        return array.length == 0;
    }

}
