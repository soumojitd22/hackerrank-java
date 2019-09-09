package com.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * modified-kaprekar-numbers
 */
public class ModifiedKaprekarNumbers {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int p = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int q = sc.nextInt();
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            kaprekarNumbers(p, q);
        }
    }

    private static void kaprekarNumbers(int p, int q) {
        List<String> kNums = new ArrayList<>();
        for (int i = p; i <= q; i++) {
            String num = String.valueOf(i);
            int d = num.length();
            String squaredNum = String.valueOf((long) pow(i, 2));
            int sd = squaredNum.length();
            int right = parseInt(squaredNum.substring(sd - d, sd));
            int left = parseInt(sd - d == 0 ? "0" : squaredNum.substring(0, sd - d));
            if (left + right == i)
                kNums.add(num);

        }
        System.out.println(kNums.size() > 0 ? String.join(" ", kNums) : "INVALID RANGE");
    }
}
