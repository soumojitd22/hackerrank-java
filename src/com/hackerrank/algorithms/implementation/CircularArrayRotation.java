package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * circular-array-rotation
 */
public class CircularArrayRotation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nkq = sc.nextLine().split(" ");
            int n = Integer.parseInt(nkq[0]);
            int k = Integer.parseInt(nkq[1]);
            int q = Integer.parseInt(nkq[2]);
            int[] a = new int[n];
            String[] aItems = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aItems[i]);
                a[i] = aItem;
            }
            int[] queries = new int[q];
            for (int i = 0; i < q; i++) {
                int queriesItem = sc.nextInt();
                sc.nextLine();
                queries[i] = queriesItem;
            }
            int[] result = circularArrayRotation(a, k, queries);
            for (int r : result) {
                System.out.println(r);
            }
        }
    }

    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        return Arrays.stream(queries)
                .map(i -> (i - (k % a.length)) < 0 ? a[a.length + (i - (k % a.length))] : a[i - (k % a.length)])
                .toArray();

    }
}
