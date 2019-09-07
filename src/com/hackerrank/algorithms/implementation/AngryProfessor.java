package com.hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 * angry-professor
 */
public class AngryProfessor {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int tItr = 0; tItr < t; tItr++) {
                String[] nk = sc.nextLine().split(" ");
                int n = Integer.parseInt(nk[0]);
                int k = Integer.parseInt(nk[1]);
                int[] a = new int[n];
                String[] aItems = sc.nextLine().split(" ");
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int i = 0; i < n; i++) {
                    int aItem = Integer.parseInt(aItems[i]);
                    a[i] = aItem;
                }
                String result = angryProfessor(k, a);
                System.out.println(result);
            }
        }
    }

    private static String angryProfessor(int k, int[] a) {
        return Arrays.stream(a).filter(i -> i <= 0).count() >= k ? "NO" : "YES";
    }
}
