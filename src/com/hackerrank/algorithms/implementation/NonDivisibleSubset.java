package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * non-divisible-subset
 */
public class NonDivisibleSubset {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            List<Integer> s = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int result = nonDivisibleSubset(k, s);
            System.out.println(result);
        }
    }

    /**
     * If (A + B) % k == 0, and A % k = x and B % k = y;
     * x + y must be equal to k or x and y both are 0
     * <p>
     * So we need to select numbers for subset by such a way that
     * x + y != k and x == 0 and y == 0
     * <p>
     * So only one number we can choose from the group where num % k == 0
     * We need to select max of x group or y group.
     * x and y both groups cannot be selected.
     *
     * @param k - k
     * @param s - List of numbers
     * @return length of subset
     */
    private static int nonDivisibleSubset(int k, List<Integer> s) {
        int count = 0;
        int[] remainderArr = new int[k];
        for (Integer i : s)
            remainderArr[i % k]++;

        if (remainderArr[0] > 0)
            count++;

        for (int i = 1; i <= k / 2; i++) {
            if (i == k / 2 && k % 2 == 0 && remainderArr[k / 2] > 0)
                count++;
            else
                count += Math.max(remainderArr[i], remainderArr[k - i]);

        }
        return count;
    }
}
