package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * divisible-sum-pairs
 */
public class DivisibleSumPair {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            List<Integer> ar = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int result = divisibleSumPair(n, k, ar);
            System.out.println(result);
        }
    }

    private static int divisibleSumPair(int n, int k, List<Integer> ar) {
        int count;
        int[] mod = new int[k];
        for (int a : ar) {
            mod[a % k]++;
        }
        count = (mod[0] * (mod[0] - 1)) / 2;
        for (int i = 1; i < k - i; i++) {
            count += mod[i] * mod[k - i];
        }
        if (k % 2 == 0)
            count += (mod[k / 2] * (mod[k / 2] - 1)) / 2;

        return count;
    }
}
