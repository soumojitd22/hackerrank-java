package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * drawing-book
 */
public class DrawingBook {
    public static void main(String[] args)  {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int p = scanner.nextInt();
            int result = pageCount(n, p);
            System.out.println(result);
        }
    }

    private static int pageCount(int n, int p) {
        if (p == 1 || p == n)
            return 0;

        int forward = (p - 1) / 2 + (p - 1) % 2;
        int backward = n % 2 == 0 ? (n - p) / 2 + (n - p) % 2 : (n - 1 - p) / 2 + (n - 1 - p) % 2;
        return Math.min(forward, backward);
    }
}
