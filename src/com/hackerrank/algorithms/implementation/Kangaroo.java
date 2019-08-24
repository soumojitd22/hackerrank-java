package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/***
 * kangaroo
 */
public class Kangaroo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] x1V1X2V2 = scanner.nextLine().split(" ");
            int x1 = Integer.parseInt(x1V1X2V2[0]);
            int v1 = Integer.parseInt(x1V1X2V2[1]);
            int x2 = Integer.parseInt(x1V1X2V2[2]);
            int v2 = Integer.parseInt(x1V1X2V2[3]);
            String result = kangaroo(x1, v1, x2, v2);
            System.out.println(result);
        }
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2 && v1 == v2)
            return "YES";
        else if (v1 == v2)
            return "NO";

        return ((x2 - x1) / (v1 - v2)) > 0 && ((x2 - x1) % (v1 - v2)) == 0 ? "YES" : "NO";
    }
}
