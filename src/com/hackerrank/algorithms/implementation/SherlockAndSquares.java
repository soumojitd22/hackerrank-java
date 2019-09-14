package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * sherlock-and-squares
 */
public class SherlockAndSquares {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int q = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int qItr = 0; qItr < q; qItr++) {
                String[] ab = sc.nextLine().split(" ");
                int a = Integer.parseInt(ab[0]);
                int b = Integer.parseInt(ab[1]);
                int result = squares(a, b);
                System.out.println(result);
            }
        }
    }

    private static int squares(int a, int b) {
        int x = (int) Math.ceil(Math.sqrt(a));
        int y = (int) Math.floor(Math.sqrt(b));
        return y - x + 1;
    }
}
