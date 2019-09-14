package com.hackerrank.algorithms.implementation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * minimum-distances
 */
public class MinimumDistances {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] a = new int[n];
            String[] aItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }
            int result = minimumDistances(a);
            System.out.println(result);
        }
    }

    private static int minimumDistances(int[] a) {
        Map<Integer, Integer> d = new HashMap<>();
        int minDistance = a.length;
        for (int i = 0; i < a.length; i++) {
            if (d.containsKey(a[i]))
                minDistance = min(abs(d.get(a[i]) - i), minDistance);

            d.put(a[i], i);
        }
        return minDistance == a.length ? -1 : minDistance;
    }
}
