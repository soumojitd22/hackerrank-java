package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * equalize-the-array
 */
public class EqualizeTheArray {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] arr = new int[n];
            String[] arrItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
            int result = equalizeArray(arr);
            System.out.println(result);
        }
    }

    private static int equalizeArray(int[] arr) {
        int maxOccurrence = Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .max()
                .orElse(0);

        return arr.length - maxOccurrence;
    }
}
