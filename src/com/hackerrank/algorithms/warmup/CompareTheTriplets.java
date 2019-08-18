package com.hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CompareTheTriplets {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            List<Integer> a = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> b = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            List<Integer> result = compareTriplets(a, b);
            System.out.println(result.stream()
                    .map(Object::toString)
                    .collect(joining(" ")));

        }
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int[] r = new int[]{0, 0};
        for (int i = 0; i < 3; i++) {
            if (a.get(i) > b.get(i))
                r[0] += 1;
            else if (b.get(i) > a.get(i))
                r[1] += 1;

        }
        return Arrays.stream(r).boxed().collect(toList());
    }
}
