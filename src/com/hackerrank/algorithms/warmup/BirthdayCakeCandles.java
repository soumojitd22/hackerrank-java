package com.hackerrank.algorithms.warmup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BirthdayCakeCandles {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int arCount = scanner.nextInt();
            scanner.nextLine();
            int[] ar = new int[arCount];
            String[] arItems = scanner.nextLine().split(" ");
            for (int i = 0; i < arCount; i++) {
                int arItem = Integer.parseInt(arItems[i]);
                ar[i] = arItem;
            }
            int result = birthdayCakeCandles(ar);
            System.out.print(result);
        }
    }

    private static int birthdayCakeCandles(int[] ar) {
        List<Integer> list = Arrays.stream(ar).boxed().collect(Collectors.toList());
        return Collections.frequency(list, list.stream().max(Integer::compareTo).orElse(0));
    }
}
