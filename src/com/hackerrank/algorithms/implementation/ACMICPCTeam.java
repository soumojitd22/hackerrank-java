package com.hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * acm-icpc-team
 */
public class ACMICPCTeam {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] topic = new String[n];
            for (int i = 0; i < n; i++) {
                String topicItem = sc.nextLine();
                topic[i] = topicItem;
            }
            int[] result = acmTeam(n, m, topic);
            for (int value : result) {
                System.out.println(value);
            }
        }
    }

    private static int[] acmTeam(int n, int m, String[] topic) {
        int maxSkills = 0;
        int maxSkillTeams = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int skillSets = new BigInteger(topic[i], 2).or(new BigInteger(topic[j], 2)).bitCount();
                if (skillSets > maxSkills) {
                    maxSkillTeams = 1;
                    maxSkills = skillSets;
                } else if (skillSets == maxSkills) {
                    maxSkillTeams++;
                }
            }
        }
        return new int[]{maxSkills, maxSkillTeams};
    }
}
