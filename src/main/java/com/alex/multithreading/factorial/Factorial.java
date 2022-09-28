package com.alex.multithreading.factorial;

import com.alex.multithreading.common.Assert;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

/**
 * Class whose single responsibility
 * is to calculate the Factorial of n
 *
 * @author Alex Angulo
 */
public final class Factorial {

    /**
     * Calculate the factorial of a number
     *
     * @param  n  the number. Must be greater than 0.
     * @return    the factorial of n as a BigInteger,
     *            to avoid Integer overflow
     */
    public static BigInteger of(int n) {
        Assert.isGreaterThan(0, n);
        return factorial(BigInteger.valueOf(n));
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.equals(ONE))
            return n;

        return n.multiply(factorial(n.subtract(ONE))); // Recursive call
    }

}
