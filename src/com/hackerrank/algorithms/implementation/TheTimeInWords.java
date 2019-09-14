package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * the-time-in-words
 */
public class TheTimeInWords {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int h = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int m = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String result = timeInWords(h, m);
            System.out.println(result);
        }
    }

    private static String timeInWords(int h, int m) {
        final String[] words = {"o' clock", "one minute", "two minutes", "three minutes", "four minutes",
                "five minutes", "six minutes", "seven minutes", "eight minutes", "nine minutes", "ten minutes",
                "eleven minutes", "twelve minutes", "thirteen minutes", "fourteen minutes", "quarter",
                "sixteen minutes", "seventeen minutes", "eighteen minutes", "nineteen minutes", "twenty minutes",
                "twenty one minutes", "twenty two minutes", "twenty three minutes", "twenty four minutes",
                "twenty five minutes", "twenty six minutes", "twenty seven minutes", "twenty eight minutes",
                "twenty nine minutes", "half"};

        String time;
        if (m == 0)
            time = words[h].split(" ")[0] + " " + words[m];
        else if (m > 30)
            time = words[(60 - m)] + " to " + words[h + 1].split(" ")[0];
        else
            time = words[m] + " past " + words[h].split(" ")[0];

        return time;
    }
}
