package com.hackerrank.algorithms.implementation;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SimpleFactorial {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            List<Integer> integers = IntStream.range(0, n)
                    .boxed()
                    .map(i -> sc.nextInt())
                    .sorted().toList();

            double[] factorials = new double[21];
            double sum = integers.stream()
                    .mapToDouble(i -> factorial(i, factorials))
                    .sum();

            System.out.println((int) (sum % 107));
        }
    }

    private static double factorial(int num, double[] factorials) {
        double f = 1;
        int n = num;
        while (n > 1 && factorials[n] == 0L) {
            f *= n--;
        }
        f = factorials[num] = f * (factorials[n] == 0L ? 1 : factorials[n]);
        return f;
    }
}
