package com.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * climbing-the-leaderboard
 */
public class ClimbingTheLeaderboard {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int scoresCount = sc.nextInt();
            sc.nextLine();
            int[] scores = new int[scoresCount];
            String[] scoresItems = sc.nextLine().split(" ");
            for (int i = 0; i < scoresCount; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }
            int aliceCount = sc.nextInt();
            sc.nextLine();
            int[] alice = new int[aliceCount];
            String[] aliceItems = sc.nextLine().split(" ");
            for (int i = 0; i < aliceCount; i++) {
                int aliceItem = Integer.parseInt(aliceItems[i]);
                alice[i] = aliceItem;
            }
            int[] result = climbingLeaderboard(scores, alice);
            for (int value : result) {
                System.out.println(value);
            }
        }
    }

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        List<Integer> ranks = new ArrayList<>();
        ranks.add(scores[0]);
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] != scores[i - 1])
                ranks.add(scores[i]);

        }
        int j = ranks.size() - 1;
        for (int i = 0; i < alice.length; i++) {
            while (j >= 0 && alice[i] > ranks.get(j))
                j--;

            if (j == -1)
                alice[i] = 1;
            else if (alice[i] == ranks.get(j))
                alice[i] = j + 1;
            else
                alice[i] = j + 2;

        }
        return alice;
    }
}
