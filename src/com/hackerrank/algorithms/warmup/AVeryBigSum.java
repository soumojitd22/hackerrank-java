package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class AVeryBigSum {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            long[] ar = new long[n];
            String[] arItems = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                long arItem = Long.parseLong(arItems[i]);
                ar[i] = arItem;
            }
            long result = aVeryBigSum(ar);
            System.out.println(result);
        }
    }

    static long aVeryBigSum(long[] ar) {
        long s = 0;
        for (long l : ar) {
            s += l;
        }
        return s;
    }
}
