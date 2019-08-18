package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            String s = scan.nextLine();
            String result = timeConversion(s);
            System.out.print(result);
        }
    }

    private static String timeConversion(String s) {
        String[] timeSplits = s.split(":");
        String hh = timeSplits[0];
        String mm = timeSplits[1];
        String ss = timeSplits[2];
        String zz = ss.endsWith("AM") ? "AM" : "PM";
        ss = ss.replace(zz, "");
        if (hh.equals("12") && zz.equals("AM"))
            hh = "00";
        else if (!hh.equals("12") && zz.equals("PM"))
            hh = String.valueOf(Integer.parseInt(hh) + 12);

        return hh + ":" + mm + ":" + ss;
    }
}
