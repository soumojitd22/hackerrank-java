package com.hackerrank.algorithms.warmup;

import java.util.Scanner;

public class SimpleArraySum {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arCount = Integer.parseInt(scanner.nextLine().trim());
            int[] ar = new int[arCount];
            String[] arItems = scanner.nextLine().split(" ");
            for (int arItr = 0; arItr < arCount; arItr++) {
                int arItem = Integer.parseInt(arItems[arItr].trim());
                ar[arItr] = arItem;
            }
            int result = simpleArraySum(ar);
            System.out.println(result);
        }
    }

    static int simpleArraySum(int[] ar) {
        int s = 0;
        for (int i : ar) {
            s += i;
        }
        return s;
    }
}
