package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * forming-a-magic-square
 */
public class FormingAMagicSquare {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[][] s = new int[3][3];
            for (int i = 0; i < 3; i++) {
                String[] sRowItems = sc.nextLine().split(" ");
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j = 0; j < 3; j++) {
                    int sItem = Integer.parseInt(sRowItems[j]);
                    s[i][j] = sItem;
                }
            }
            int result = formingMagicSquare(s);
            System.out.println(result);
        }
    }

    private static int formingMagicSquare(int[][] s) {
        int[][][] possibleMagicSquares = new int[][][]{
                {{8, 1, 6}, {3, 5, 7}, {4, 9, 2}},
                {{6, 1, 8}, {7, 5, 3}, {2, 9, 4}},
                {{4, 9, 2}, {3, 5, 7}, {8, 1, 6}},
                {{2, 9, 4}, {7, 5, 3}, {6, 1, 8}},
                {{8, 3, 4}, {1, 5, 9}, {6, 7, 2}},
                {{4, 3, 8}, {9, 5, 1}, {2, 7, 6}},
                {{6, 7, 2}, {1, 5, 9}, {8, 3, 4}},
                {{2, 7, 6}, {9, 5, 1}, {4, 3, 8}}
        };
        int cost;
        int min = 0;
        for (int i = 0; i < possibleMagicSquares.length; i++) {
            cost = 0;
            for (int j = 0; j < possibleMagicSquares[i].length; j++) {
                for (int k = 0; k < possibleMagicSquares[i][j].length; k++) {
                    cost += Math.abs(s[j][k] - possibleMagicSquares[i][j][k]);
                }
            }
            if (i == 0)
                min = cost;
            else if (cost < min)
                min = cost;

        }
        return min;
    }
}
