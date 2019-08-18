package com.hackerrank.algorithms.warmup;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DiagonalDifference {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = Integer.parseInt(sc.nextLine().trim());
            List<List<Integer>> arr = new ArrayList<>();
            IntStream.range(0, n).forEach(i -> arr.add(
                    Stream.of(sc.nextLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(toList())
            ));
            int result = diagonalDifference(arr);
            System.out.println(result);
        }
    }

    private static int diagonalDifference(List<List<Integer>> arr) {
        final int l = arr.size();
        int lDiag = IntStream.range(0, l)
                .map(i -> arr.get(i).get(i))
                .sum();

        int rDiag = IntStream.range(0, l)
                .map(i -> arr.get(i).get(l - i - 1))
                .sum();

        return Math.abs(lDiag - rDiag);
    }
}
