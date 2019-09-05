package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * cut-the-sticks
 */
public class CutTheSticks {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] arr = Arrays.stream(sc.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] result = cutTheSticks(arr);
            for (int value : result) {
                System.out.println(value);
            }
        }
    }

    private static int[] cutTheSticks(int[] arr) {
        Arrays.sort(arr);
        return IntStream.range(0, arr.length)
                .filter(i -> i == 0 || arr[i] != arr[i - 1])
                .map(i -> arr.length - i)
                .toArray();

    }
}
