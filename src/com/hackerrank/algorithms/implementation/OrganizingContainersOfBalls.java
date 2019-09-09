package com.hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * organizing-containers-of-balls
 */
public class OrganizingContainersOfBalls {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int q = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int qItr = 0; qItr < q; qItr++) {
                int n = sc.nextInt();
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                int[][] container = new int[n][n];
                for (int i = 0; i < n; i++) {
                    String[] containerRowItems = sc.nextLine().split(" ");
                    sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                    for (int j = 0; j < n; j++) {
                        int containerItem = Integer.parseInt(containerRowItems[j]);
                        container[i][j] = containerItem;
                    }
                }
                String result = organizingContainers(container);
                System.out.println(result);
            }
        }
    }

    private static String organizingContainers(int[][] c) {
        Map<Long, Integer> d = new HashMap<>();
        int n = c.length;
        for (int i = 0; i < n; i++) {
            long totalOfAType = 0L;
            for (int[] container : c) {
                totalOfAType += container[i];
            }
            d.put(totalOfAType, i);
        }

        for (int[] container : c) {
            long totalOfAContainer = 0L;
            for (int j = 0; j < n; j++) {
                totalOfAContainer += container[j];
            }
            if (!d.containsKey(totalOfAContainer))
                return "Impossible";

        }
        return "Possible";
    }
}
