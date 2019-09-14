package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

import static java.lang.Math.max;

/**
 * flatland-space-stations
 */
public class FlatlandSpaceStations {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            int[] c = new int[m];
            String[] cItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < m; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }
            int result = flatlandSpaceStations(n, c);
            System.out.println(result);
        }
    }

    private static int flatlandSpaceStations(int n, int[] c) {
        if (c.length == 1)
            return max(c[0], n - 1 - c[0]);

        Arrays.sort(c);
        int maxDistanceInBetween = IntStream.range(1, c.length)
                .map(i -> (c[i] - c[i - 1]) / 2)
                .max()
                .orElse(0);

        return max(max(c[0], n - 1 - c[c.length - 1]), maxDistanceInBetween);
    }
}
