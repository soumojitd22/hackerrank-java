package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * chocolate-feast
 */
public class ChocolateFeast {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int tItr = 0; tItr < t; tItr++) {
                String[] ncm = sc.nextLine().split(" ");
                int n = Integer.parseInt(ncm[0]);
                int c = Integer.parseInt(ncm[1]);
                int m = Integer.parseInt(ncm[2]);
                int result = chocolateFeast(n, c, m);
                System.out.println(result);
            }
        }
    }

    private static int chocolateFeast(int n, int c, int m) {
        int wrappers = n / c;
        int count = wrappers;
        while (wrappers >= m) {
            int chocolatesGained = wrappers / m;
            count += chocolatesGained;
            wrappers = chocolatesGained + (wrappers % m);
        }
        return count;
    }
}
