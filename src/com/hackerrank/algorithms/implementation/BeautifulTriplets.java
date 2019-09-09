package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * beautiful-triplets
 */
public class BeautifulTriplets {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nd = sc.nextLine().split(" ");
            int n = Integer.parseInt(nd[0]);
            int d = Integer.parseInt(nd[1]);
            int[] arr = new int[n];
            String[] arrItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }
            int result = beautifulTriplets(d, arr);
            System.out.println(result);
        }
    }

    private static int beautifulTriplets(int d, int[] arr) {
        Map<Integer, Long> c = Arrays.stream(arr)
                .boxed()
                .collect(groupingBy(identity(), counting()));

        return c.keySet()
                .stream()
                .filter(i -> c.containsKey(i + d) && c.containsKey(i + 2 * d))
                .mapToInt(i -> (int) (c.get(i) * c.get(i + d) * c.get(i + 2 * d)))
                .sum();

    }
}
