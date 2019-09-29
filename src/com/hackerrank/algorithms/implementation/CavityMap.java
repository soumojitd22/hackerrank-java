package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * cavity-map
 */
public class CavityMap {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String[] grid = new String[n];
            for (int i = 0; i < n; i++) {
                String gridItem = sc.nextLine();
                grid[i] = gridItem;
            }
            String[] result = cavityMap(grid);
            for (String s : result) {
                System.out.println(s);
            }
        }
    }

    private static String[] cavityMap(String[] grid) {
        int n = grid.length;
        for (int r = 1; r < n - 1; r++) {
            String s = grid[r];
            String sp = grid[r - 1];
            String sn = grid[r + 1];
            for (int c = 1; c < n - 1; c++) {
                if (s.charAt(c) > s.charAt(c + 1)
                        && s.charAt(c) > sp.charAt(c)
                        && s.charAt(c) > s.charAt(c - 1)
                        && s.charAt(c) > sn.charAt(c)) {

                    grid[r] = grid[r].substring(0, c) + "X" + grid[r].substring(c + 1);
                }
            }
        }
        return grid;
    }
}
