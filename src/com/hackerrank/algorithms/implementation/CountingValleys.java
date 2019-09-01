package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * counting-valleys
 */
public class CountingValleys {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int result = countingValleys(n, s);
            System.out.println(result);
        }
    }

    private static int countingValleys(int n, String s) {
        int alt = 0;
        int v = 0;
        for (char step : s.toCharArray()) {
            if (step == 'U') {
                alt++;
                if (alt == 0)
                    v++;

            } else if (step == 'D') {
                alt--;
            }
        }
        return v;
    }
}
