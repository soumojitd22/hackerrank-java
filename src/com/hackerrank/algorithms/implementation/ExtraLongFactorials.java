package com.hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * extra-long-factorials
 */
public class ExtraLongFactorials {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            extraLongFactorials(n);
        }
    }

    private static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        System.out.println(factorial);
    }
}
