package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

import static java.lang.String.format;

public class StairCase {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            staircase(n);
        }
    }

    private static void staircase(int n) {
        for (int i = 0; i < n; i++)
            System.out.println(format("%" + n + "s", format("%" + (i + 1) + "s", "").replace(" ", "#")));

    }
}
