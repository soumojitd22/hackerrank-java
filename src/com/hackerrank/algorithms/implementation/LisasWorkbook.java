package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * lisas-workbook
 */
public class LisasWorkbook {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] arr = new int[n];
            String[] arrItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
            int result = workbook(n, k, arr);
            System.out.println(result);
        }
    }

    private static int workbook(int n, int k, int[] arr) {
        int startPage = 1;
        int count = 0;
        for (int problems : arr) {
            int endPage = startPage + (problems / k) + (problems % k == 0 ? 0 : 1) - 1;
            int startProb = 1;
            for (int p = startPage; p <= endPage; p++) {
                int endProb = Math.min((startProb + k - 1), problems);
                if (startProb <= p && p <= endProb)
                    count++;

                startProb = endProb + 1;
            }
            startPage = endPage + 1;
        }
        return count;
    }
}
