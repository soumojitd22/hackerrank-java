package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * service-lane
 */
public class ServiceLane {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nt = sc.nextLine().split(" ");
            int n = Integer.parseInt(nt[0]);
            int t = Integer.parseInt(nt[1]);
            int[] width = new int[n];
            String[] widthItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int widthItem = Integer.parseInt(widthItems[i]);
                width[i] = widthItem;
            }
            int[][] cases = new int[t][2];
            for (int i = 0; i < t; i++) {
                String[] casesRowItems = sc.nextLine().split(" ");
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j = 0; j < 2; j++) {
                    int casesItem = Integer.parseInt(casesRowItems[j]);
                    cases[i][j] = casesItem;
                }
            }
            int[] result = serviceLane(width, cases);
            for (int value : result) {
                System.out.println(value);
            }
        }
    }

    private static int[] serviceLane(int[] width, int[][] cases) {
        int[] result = new int[cases.length];
        for (int i = 0; i < cases.length; i++) {
            int startWidthIdx = cases[i][0];
            int endWidthIdx = cases[i][1];
            int min = Arrays.stream(width, startWidthIdx, endWidthIdx + 1)
                    .min()
                    .orElse(0);

            result[i] = min;
        }
        return result;
    }
}
