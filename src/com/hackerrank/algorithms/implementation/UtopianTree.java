package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * utopian-tree
 */
public class UtopianTree {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int tItr = 0; tItr < t; tItr++) {
                int n = sc.nextInt();
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                int result = utopianTree(n);
                System.out.println(result);
            }
        }
    }

    private static int utopianTree(int n) {
        return (int) (Math.pow(2, Math.floorDiv(n, 2) + 1) - 1) * (n % 2 + 1);
    }
}
