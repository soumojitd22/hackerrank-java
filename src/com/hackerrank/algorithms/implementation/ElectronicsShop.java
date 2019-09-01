package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

import static java.util.Arrays.sort;
import static java.util.Collections.reverseOrder;

/**
 * electronics-shop
 */
public class ElectronicsShop {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int b = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            Integer[] keyboards = new Integer[n];
            for (int i = 0; i < n; i++) {
                keyboards[i] = sc.nextInt();
            }
            Integer[] drives = new Integer[m];
            for (int i = 0; i < m; i++) {
                drives[i] = sc.nextInt();
            }
            int moneySpent = getMoneySpent(keyboards, drives, b);
            System.out.println(moneySpent);
        }
    }

    private static int getMoneySpent(Integer[] keyboards, Integer[] drives, int b) {
        sort(keyboards, reverseOrder());
        sort(drives, reverseOrder());
        int maxSpent = -1;
        for (Integer keyboard : keyboards) {
            int j = 0;
            if (keyboard + drives[j] < maxSpent)
                return maxSpent;

            while (j < drives.length && keyboard + drives[j] > b)
                j++;

            if (j < drives.length)
                maxSpent = Math.max(maxSpent, keyboard + drives[j]);

        }
        return maxSpent;
    }
}
