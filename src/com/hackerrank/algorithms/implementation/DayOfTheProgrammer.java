package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * day-of-the-programmer
 */
public class DayOfTheProgrammer {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int year = sc.nextInt();
            String result = dayOfProgrammer(year);
            System.out.println(result);
        }
    }

    private static String dayOfProgrammer(int year) {
        String programmersDay = "13.09.";
        if (year == 1918)
            programmersDay = "26.09.";
        else if (year < 1918) {
            // To check Leap Year : If divisible by 4
            if (year % 4 == 0)
                programmersDay = "12.09.";

        } else {
            // To check Leap Year :If divisible by 400 or divisible by 4 and not divisible by 100
            if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
                programmersDay = "12.09.";

        }
        return programmersDay + year;
    }
}
