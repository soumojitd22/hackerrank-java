package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * picking-numbers
 */
public class PickingNumbers {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            List<Integer> a = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = pickingNumbers(a);
            System.out.println(result);
        }
    }

    private static int pickingNumbers(List<Integer> a) {
        Map<Integer, Long> counter = a.stream()
                .collect(groupingBy(identity(), counting()));

        long count = 0;
        for (int i : counter.keySet()) {
            if (counter.containsKey(i + 1) && (counter.get(i) + counter.get(i + 1) > count))
                count = counter.get(i) + counter.get(i + 1);
            else if (counter.get(i) > count)
                count = counter.get(i);

        }
        return (int) count;
    }
}
