package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * find-digits
 */
public class FindDigits {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int tItr = 0; tItr < t; tItr++) {
                int n = sc.nextInt();
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                int result = findDigits(n);
                System.out.println(result);
            }
        }
    }

    private static int findDigits(int n) {
        int num = n;
        int count = 0;
        while (num > 0) {
            int d = num % 10;
            num /= 10;
            if (d != 0 && n % d == 0)
                count++;

        }
        return count;
    }
}
