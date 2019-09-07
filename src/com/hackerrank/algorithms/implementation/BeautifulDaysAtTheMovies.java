package com.hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * beautiful-days-at-the-movies
 */
public class BeautifulDaysAtTheMovies {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] ijk = sc.nextLine().split(" ");
            int i = Integer.parseInt(ijk[0]);
            int j = Integer.parseInt(ijk[1]);
            int k = Integer.parseInt(ijk[2]);
            int result = beautifulDays(i, j, k);
            System.out.println(result);
        }
    }

    private static int beautifulDays(int i, int j, int k) {
        return (int) IntStream.range(i, j + 1)
                .filter(day -> Math.abs(day - Integer.parseInt(new StringBuilder(String.valueOf(day)).reverse().toString())) % k == 0)
                .count();

    }
}
