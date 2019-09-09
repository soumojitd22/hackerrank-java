package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * bigger-is-greater
 */
public class BiggerIsGreater {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            while (--t >= 0)
                System.out.println(biggerIsGreater(sc.nextLine()));

        }
    }

    private static String biggerIsGreater(String w) {
        String biggerWord = "no answer";
        StringBuilder sb = new StringBuilder(w);
        int l = sb.length();
        if (l > 1) {
            int i = l - 1;
            while (sb.charAt(i) <= sb.charAt(i - 1) && --i > 0) ;
            int charPos1 = i - 1;
            if (charPos1 != -1) {
                i = l;
                while (--i >= charPos1 + 1 && sb.charAt(i) <= sb.charAt(charPos1)) ;
                int charPos2 = i;
                swap(sb, charPos1, charPos2);
                reverse(sb, charPos1 + 1);
                biggerWord = sb.toString();
            }
        }
        return biggerWord;
    }

    private static void swap(StringBuilder sb, final int sPos, final int ePos) {
        char temp = sb.charAt(sPos);
        sb.setCharAt(sPos, sb.charAt(ePos));
        sb.setCharAt(ePos, temp);
    }

    private static void reverse(StringBuilder sb, final int sPos) {
        StringBuilder tempSb = new StringBuilder(sb.substring(sPos));
        tempSb.reverse();
        sb.replace(sPos, sb.length(), tempSb.toString());
    }
}
