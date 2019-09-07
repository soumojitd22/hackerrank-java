package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * jumping-on-the-clouds-revisited
 */
public class JumpingOnTheCloudsRevisited {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            int[] c = new int[n];
            String[] cItems = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }
            int result = jumpingOnClouds(c, k);
            System.out.println(result);
        }
    }

    private static int jumpingOnClouds(int[] c, int k) {
        int n = c.length;
        int i = k % n;
        int e = 100;
        while (i != 0) {
            e = c[i] == 1 ? e - 3 : e - 1;
            i = (i + k) % n;
        }

        // Energy would be lost to jump on last cloud also
        e = c[i] == 1 ? e - 3 : e - 1;
        return e;
    }
}
