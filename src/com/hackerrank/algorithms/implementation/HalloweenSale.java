package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * halloween-sale
 */
public class HalloweenSale {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] pdms = sc.nextLine().split(" ");
            int p = Integer.parseInt(pdms[0]);
            int d = Integer.parseInt(pdms[1]);
            int m = Integer.parseInt(pdms[2]);
            int s = Integer.parseInt(pdms[3]);
            int answer = howManyGames(p, d, m, s);
            System.out.println(answer);
        }
    }

    private static int howManyGames(int p, int d, int m, int s) {
        int games = 0;
        while (s >= 0) {
            s -= p;
            p = max(p - d, m);
            games++;
        }
        return games - 1;
    }
}
