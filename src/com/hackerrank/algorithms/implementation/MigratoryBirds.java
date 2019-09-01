package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

/**
 * migratory-birds
 */
public class MigratoryBirds {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int arrCount = sc.nextInt();
            sc.nextLine();
            List<Integer> arr = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = migratoryBirds(arr);
            System.out.println(result);
        }
    }

    private static int migratoryBirds(List<Integer> arr) {
        return arr.stream()
                .collect(groupingBy(identity(), counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

    }
}
