package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * fair-ration
 */
public class FairRation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] B = new int[N];
            String[] BItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < N; i++) {
                int BItem = Integer.parseInt(BItems[i]);
                B[i] = BItem;
            }
            String result = fairRations(B);
            System.out.println(result);
        }
    }

    private static String fairRations(int[] b) {
        if (Arrays.stream(b).sum() % 2 != 0)
            return "NO";

        int count = 0;
        int i = 0;
        while (i < b.length - 1) {
            if (b[i] % 2 != 0) {
                b[i]++;
                b[i + 1]++;
                count += 2;
            }
            i++;
        }
        return String.valueOf(count);
    }
}
