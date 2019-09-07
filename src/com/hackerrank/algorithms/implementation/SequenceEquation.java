package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * sequence-equation
 */
public class SequenceEquation {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.nextLine();
            int[] p = new int[n];
            String[] pItems = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int pItem = Integer.parseInt(pItems[i]);
                p[i] = pItem;
            }
            int[] result = permutationEquation(p);
            for (int value : result) {
                System.out.println(value);
            }
        }
    }

    private static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        for (int i : p)
            result[p[p[i - 1] - 1] - 1] = i;

        return result;
    }
}
