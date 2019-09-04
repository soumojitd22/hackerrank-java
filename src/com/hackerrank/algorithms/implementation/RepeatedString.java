package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * repeated-string
 */
public class RepeatedString {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            long n = sc.nextLong();
            long result = repeatedString(s, n);
            System.out.println(result);
        }
    }

    private static long repeatedString(String s, long n) {
        return (s.split("a", -1).length - 1) * (n / s.length())
                + (s.substring(0, (int) (n % s.length())).split("a", -1).length - 1);

    }
}
