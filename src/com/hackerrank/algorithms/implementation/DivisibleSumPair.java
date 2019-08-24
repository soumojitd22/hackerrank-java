package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        return IntStream.range(0, n - 1)
                .map(i -> (int) IntStream.range(i + 1, n).filter(j -> (ar.get(i) + ar.get(j)) % k == 0).count())
                .sum();

    }
}
