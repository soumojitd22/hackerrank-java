package com.hackerrank.algorithms.interview;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwap2 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int res = minimumSwaps(arr);
            System.out.println(res);
        }
    }

    private static int minimumSwaps(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] - (i + 1);
        }
        System.out.println(Arrays.toString(arr));

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                continue;

            arr[i] = arr[i] + arr[i + arr[i]] + (arr[i + arr[i]] = 0);
            count++;
            i--;
        }
        return count;
    }
}
