package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * between-two-sets
 */
public class BetweenTwoSets {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] firstMultipleInput = sc.nextLine().split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            List<Integer> arr = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> brr = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int total = getTotalX(arr, brr);
            System.out.println(total);
        }
    }

    private static int getTotalX(List<Integer> a, List<Integer> b) {
        int a_max = a.stream().max(Integer::compareTo).orElse(0);
        int b_min = b.stream().min(Integer::compareTo).orElse(0);
        return (int) IntStream.range(1, (b_min / a_max) + 1)
                .filter(i -> filterCondition(i, a_max, a, b))
                .count();

    }

    private static boolean filterCondition(int i, int a_max, List<Integer> a, List<Integer> b) {
        int sum_a = a.stream()
                .map(j -> (i * a_max) % j)
                .mapToInt(Integer::intValue)
                .sum();

        int sum_b = b.stream()
                .map(j -> (j % (i * a_max)))
                .mapToInt(Integer::intValue)
                .sum();

        return sum_a + sum_b == 0;
    }
}
