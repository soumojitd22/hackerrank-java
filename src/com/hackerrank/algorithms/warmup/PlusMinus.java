package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

import static java.lang.String.format;

public class PlusMinus {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] arr = new int[n];
            String[] arrItems = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
            plusMinus(arr);
        }
    }

    private static void plusMinus(int[] arr) {
        int length = arr.length;
        int gtZero = 0, ltZero = 0, zero = 0;
        for (int a : arr) {
            if (a == 0)
                zero++;
            else if (a > 0)
                gtZero++;
            else
                ltZero++;

        }
        System.out.println(format("%.6f", (float) gtZero / length));
        System.out.println(format("%.6f", (float) ltZero / length));
        System.out.println(format("%.6f", (float) zero / length));
    }
}
