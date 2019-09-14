package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * jumping-on-clouds
 */
public class JumpingOnClouds {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] c = new int[n];
            String[] cItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int cItem = Integer.parseInt(cItems[i]);
                c[i] = cItem;
            }
            int result = jumpingOnClouds(c);
            System.out.println(result);
        }
    }

    private static int jumpingOnClouds(int[] c) {
        int i = 0;
        int count = 0;
        while (i < c.length - 3) {
            if (c[i + 2] == 1)
                i += 1;
            else
                i += 2;

            count++;
        }
        return count + 1;
    }
}
