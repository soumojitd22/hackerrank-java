package com.hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * the-bomberman-game
 */
public class TheBombermanGame {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] rcn = sc.nextLine().split(" ");
            int r = Integer.parseInt(rcn[0]);
            int c = Integer.parseInt(rcn[1]);
            int n = Integer.parseInt(rcn[2]);
            String[] grid = new String[r];
            for (int i = 0; i < r; i++) {
                String gridItem = sc.nextLine();
                grid[i] = gridItem;
            }
            String[] result = bomberMan(n, r, c, grid);
            for (String s : result) System.out.println(s);
        }
    }

    /**
     * n = 1 --> Nothing happens
     * n = 2, 4, 6, 8, ....(any even) --> bomberman fills up the empty places with bombs.
     * So the grid would be full of bombs.
     * n = 3 --> Bombs placed at n = 1 will detonate
     * n = 5 --> After detonation at n = 3, remaining bombs will detonate. So to determine grid after n = 5,
     * we need to first determine grid after n = 3.
     * n = 7, 11, 15, 19, ....(n % 4 == 3) --> The grid looks same as after n = 3
     * n = 9, 13, 17, 21, ....(n % 4 == 1) --> The grid looks same as after n = 5
     *
     * @param n    Time
     * @param r    Row
     * @param c    Column
     * @param grid Grid
     * @return Grid after time n
     */
    private static String[] bomberMan(int n, int r, int c, String[] grid) {
        String[] res = new String[r];
        if (n == 1) {
            res = grid;
        } else if (n % 2 == 0) {
            IntStream.range(0, r)
                    .mapToObj(i -> String.format("%" + c + "s", "O").replaceAll(" ", "O"))
                    .collect(Collectors.toList())
                    .toArray(res);

        } else if (n % 4 == 3) {
            res = afterBombDetonation(r, c, grid);
        } else if (n % 4 == 1) {
            String[] n3 = afterBombDetonation(r, c, grid);
            res = afterBombDetonation(r, c, n3);
        }
        return res;
    }

    /**
     * If a bomb exists at any of the below mentioned points, the point under consideration would be impacted -
     * The point itself
     * Up
     * Down
     * Right
     * Left
     *
     * @param r Row
     * @param c Column
     * @param g Grid
     * @return Grid after bomb detonation
     */
    private static String[] afterBombDetonation(int r, int c, String[] g) {
        String[] temp = new String[r];
        for (int i = 0; i < r; i++) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < c; j++) {
                if (g[i].charAt(j) == 'O'
                        || (i + 1 < r && g[i + 1].charAt(j) == 'O')
                        || (i - 1 >= 0 && g[i - 1].charAt(j) == 'O')
                        || (j + 1 < c && g[i].charAt(j + 1) == 'O')
                        || (j - 1 >= 0 && g[i].charAt(j - 1) == 'O')) {

                    s.append('.');
                } else {
                    s.append('O');
                }
            }
            temp[i] = s.toString();
        }
        return temp;
    }
}
