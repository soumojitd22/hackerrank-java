package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * library-fine
 */
public class LibraryFine {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] d1M1Y1 = sc.nextLine().split(" ");
            int d1 = Integer.parseInt(d1M1Y1[0]);
            int m1 = Integer.parseInt(d1M1Y1[1]);
            int y1 = Integer.parseInt(d1M1Y1[2]);
            String[] d2M2Y2 = sc.nextLine().split(" ");
            int d2 = Integer.parseInt(d2M2Y2[0]);
            int m2 = Integer.parseInt(d2M2Y2[1]);
            int y2 = Integer.parseInt(d2M2Y2[2]);
            int result = libraryFine(d1, m1, y1, d2, m2, y2);
            System.out.println(result);
        }
    }

    private static int libraryFine(int dr, int mr, int yr, int de, int me, int ye) {
        int fine;
        if (yr < ye)
            fine = 0;
        else if (yr == ye && mr < me)
            fine = 0;
        else if (yr == ye && mr == me && dr <= de)
            fine = 0;
        else if (yr > ye)
            fine = 10000;
        else if (mr > me)
            fine = 500 * (mr - me);
        else
            fine = 15 * (dr - de);

        return fine;
    }
}
