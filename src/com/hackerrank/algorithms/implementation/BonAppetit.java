package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * bon-appetit
 */
public class BonAppetit {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            List<Integer> bill = Stream.of(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

            int b = sc.nextInt();
            bonAppetit(bill, k, b);
        }
    }

    private static void bonAppetit(List<Integer> bill, int k, int b) {
        int annaBill = IntStream.range(0, bill.size())
                .filter(i -> i != k)
                .map(bill::get)
                .sum() / 2;

        System.out.println(b == annaBill ? "Bon Appetit" : (b - annaBill));
    }
}
