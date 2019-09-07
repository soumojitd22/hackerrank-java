package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * save-the-prisoner
 */
public class SaveThePrisoner {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int tItr = 0; tItr < t; tItr++) {
                String[] nms = sc.nextLine().split(" ");
                int n = Integer.parseInt(nms[0]);
                int m = Integer.parseInt(nms[1]);
                int s = Integer.parseInt(nms[2]);
                int result = saveThePrisoner(n, m, s);
                System.out.println(result);
            }
        }
    }

    private static int saveThePrisoner(int n, int m, int s) {
        return (s + m - 1) % n == 0 ? n : (s + m - 1) % n;
    }
}
