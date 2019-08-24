package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * birthday-chocolate
 */
public class BirthdayChocolate {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine().trim());
            List<Integer> s = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            String[] dm = sc.nextLine().split(" ");
            int d = Integer.parseInt(dm[0]);
            int m = Integer.parseInt(dm[1]);
            int result = birthday(s, d, m);
            System.out.println(result);
        }
    }

    private static int birthday(List<Integer> s, int d, int m) {
        return (int) IntStream.range(0, s.size() - m + 1)
                .filter(i -> IntStream.range(i, i + m).map(s::get).sum() == d)
                .count();

    }
}
