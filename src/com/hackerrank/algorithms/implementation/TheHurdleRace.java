package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * the-hurdle-race
 */
public class TheHurdleRace {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] height = new int[n];
            String[] heightItems = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int heightItem = Integer.parseInt(heightItems[i]);
                height[i] = heightItem;
            }
            int result = hurdleRace(k, height);
            System.out.println(result);
        }
    }

    private static int hurdleRace(int k, int[] height) {
        return Math.max(Arrays.stream(height).max().orElse(k) - k, 0);
    }
}
