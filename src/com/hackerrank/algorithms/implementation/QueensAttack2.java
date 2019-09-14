package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * queens-attack-2
 */
public class QueensAttack2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nk = sc.nextLine().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);
            String[] r_qC_q = sc.nextLine().split(" ");
            int r_q = Integer.parseInt(r_qC_q[0]);
            int c_q = Integer.parseInt(r_qC_q[1]);
            int[][] obstacles = new int[k][2];
            for (int i = 0; i < k; i++) {
                String[] obstaclesRowItems = sc.nextLine().split(" ");
                for (int j = 0; j < 2; j++) {
                    int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                    obstacles[i][j] = obstaclesItem;
                }
            }
            int result = queensAttack(n, k, r_q, c_q, obstacles);
            System.out.println(result);
        }
    }

    private static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int up = n - r_q;
        int down = r_q - 1;
        int right = n - c_q;
        int left = c_q - 1;
        int up_right = min(up, right);
        int up_left = min(up, left);
        int down_right = min(down, right);
        int down_left = min(down, left);
        for (int[] o : obstacles) {
            int r_o = o[0];
            int c_o = o[1];
            if (r_o == r_q) {
                // For left - right
                if (c_o > c_q)
                    right = min(c_o - c_q - 1, right);
                else
                    left = min(c_q - c_o - 1, left);

            } else if (c_o == c_q) {
                // For up - down
                if (r_o > r_q)
                    up = min(r_o - r_q - 1, up);
                else
                    down = min(r_q - r_o - 1, down);

            } else if (abs(r_o - r_q) == abs(c_o - c_q)) {
                // For diagonals
                if (r_o > r_q && c_o > c_q) {
                    // For up - right
                    up_right = min(r_o - r_q - 1, up_right);
                } else if (r_o > r_q) {
                    // For up - left
                    up_left = min(r_o - r_q - 1, up_left);
                } else if (c_o < c_q) {
                    // For down - left
                    down_left = min(r_q - r_o - 1, down_left);
                } else {
                    // For down - right
                    down_right = min(r_q - r_o - 1, down_right);
                }
            }
        }
        return up + down + left + right + up_right + up_left + down_left + down_right;
    }
}
