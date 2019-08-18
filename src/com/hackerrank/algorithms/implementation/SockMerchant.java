package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * sock-merchant
 */
public class SockMerchant {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            List<Integer> socks = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            int result = sockMerchant(n, socks);
            System.out.println(result);
        }
    }

    private static int sockMerchant(int n, List<Integer> socks) {
        return socks.stream()
                .collect(groupingBy(identity(), counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .map(v -> v / 2)
                .sum();

    }
}
