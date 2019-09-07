package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * append-and-delete
 */
public class AppendAndDelete {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            String t = sc.nextLine();
            int k = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            String result = appendAndDelete(s, t, k);
            System.out.println(result);
        }
    }

    private static String appendAndDelete(String s, String t, int k) {
        String result = "No";
        if (s.length() + t.length() <= k) {
            result = "Yes";
        } else {
            int i = 0;
            int minLength = Math.min(s.length(), t.length());
            while (i < minLength && s.charAt(i) == t.charAt(i))
                i++;

            int unmatchedS = s.length() - i;
            int unmatchedT = t.length() - i;
            int unmatchedAll = unmatchedS + unmatchedT;
            if (k >= unmatchedAll && (k - unmatchedAll) % 2 == 0)
                result = "Yes";

        }
        return result;
    }
}
