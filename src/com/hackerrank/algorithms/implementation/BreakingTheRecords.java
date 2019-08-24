package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * breaking-the-records
 */
public class BreakingTheRecords {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[] scores = new int[n];
            String[] scoresItems = scanner.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }
            int[] result = breakingRecords(scores);
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

    private static int[] breakingRecords(int[] scores) {
        int best = scores[0], worst = scores[0];
        int bestCounter = 0, worstCounter = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > best) {
                best = scores[i];
                bestCounter++;
            } else if (scores[i] < worst) {
                worst = scores[i];
                worstCounter++;
            }
        }
        return new int[]{bestCounter, worstCounter};
    }
}
