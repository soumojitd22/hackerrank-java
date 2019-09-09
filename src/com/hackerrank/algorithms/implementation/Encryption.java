package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 * encryption
 */
public class Encryption {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            String result = encryption(s);
            System.out.println(result);
        }
    }

    private static String encryption(String s) {
        int length = s.length();
        int col = (int) ceil(sqrt(length));
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < col; c++) {
            for (int r = 0; r < col; r++) {
                if (c + r * col < length)
                    sb.append(s.charAt(c + r * col));

            }
            sb.append(" ");
        }
        return sb.toString();
    }
}
