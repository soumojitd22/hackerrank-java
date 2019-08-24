package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppleAndOrange {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] st = scanner.nextLine().split(" ");
            int s = Integer.parseInt(st[0]);
            int t = Integer.parseInt(st[1]);
            String[] ab = scanner.nextLine().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            String[] mn = scanner.nextLine().split(" ");
            int m = Integer.parseInt(mn[0]);
            int n = Integer.parseInt(mn[1]);
            String[] applesItems = scanner.nextLine().split(" ");
            List<Integer> apples = Arrays.stream(applesItems)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            String[] orangesItems = scanner.nextLine().split(" ");
            List<Integer> oranges = Arrays.stream(orangesItems)
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());

            countApplesAndOranges(s, t, a, b, apples, oranges);
        }
    }

    private static void countApplesAndOranges(Integer s, Integer t, Integer a, Integer b,
                                              List<Integer> apples, List<Integer> oranges) {

        List<Integer> apple_positions = apples.stream()
                .map(apple -> apple + a)
                .collect(Collectors.toList());

        List<Integer> orange_positions = oranges.stream()
                .map(orange -> orange + b)
                .collect(Collectors.toList());

        System.out.println(apple_positions.stream()
                .filter(x -> s <= x && x <= t)
                .count());

        System.out.println(orange_positions.stream()
                .filter(x -> s <= x && x <= t)
                .count());

    }
}
