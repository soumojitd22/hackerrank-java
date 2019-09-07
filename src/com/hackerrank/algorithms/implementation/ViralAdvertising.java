package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * viral-advertising
 */
public class ViralAdvertising {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int result = viralAdvertising(n);
            System.out.println(result);
        }
    }

    private static int viralAdvertising(int n) {
        int viralCount = 2;
        int daysViral = 2;
        for (int i = 1; i < n; i++) {
            daysViral = (daysViral * 3) / 2;
            viralCount += daysViral;
        }
        return viralCount;
    }
}
