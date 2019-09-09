package com.hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * taum-and-bday
 */
public class TaumAndBday {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            sc.nextLine();
            IntStream.range(0, t).forEach(tItr -> {
                String[] firstMultipleInput = sc.nextLine().split(" ");
                int b = Integer.parseInt(firstMultipleInput[0]);
                int w = Integer.parseInt(firstMultipleInput[1]);
                String[] secondMultipleInput = sc.nextLine().split(" ");
                int bc = Integer.parseInt(secondMultipleInput[0]);
                int wc = Integer.parseInt(secondMultipleInput[1]);
                int z = Integer.parseInt(secondMultipleInput[2]);
                long result = taumBday(b, w, bc, wc, z);
                System.out.println(result);
            });
        }
    }

    private static long taumBday(long b, long w, long bc, long wc, long z) {
        long price;
        if (bc + z < wc)
            price = b * bc + w * (bc + z);
        else if (wc + z < bc)
            price = w * wc + b * (wc + z);
        else
            price = b * bc + w * wc;

        return price;
    }
}
