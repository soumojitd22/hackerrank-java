package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class MaxMiniSum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[] arr = new int[5];
            String[] arrItems = scanner.nextLine().split(" ");
            for (int i = 0; i < 5; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
            miniMaxSum(arr);
        }
    }

    private static void miniMaxSum(int[] arr) {
        int maxValue = arr[0];
        int minValue = arr[0];
        long sumArr = 0L;
        for (int a : arr) {
            if (a > maxValue)
                maxValue = a;
            else if (a < minValue)
                minValue = a;

            sumArr += a;
        }
        long minSum = sumArr - maxValue;
        long maxSum = sumArr - minValue;
        System.out.println(minSum + " " + maxSum);
    }
}
