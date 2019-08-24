package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * cats-and-a-mouse
 */
public class CatsAndAMouse {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int q = scanner.nextInt();
            scanner.nextLine();
            for (int qItr = 0; qItr < q; qItr++) {
                String[] xyz = scanner.nextLine().split(" ");
                int x = Integer.parseInt(xyz[0]);
                int y = Integer.parseInt(xyz[1]);
                int z = Integer.parseInt(xyz[2]);
                String result = catAndMouse(x, y, z);
                System.out.println(result);
            }
        }
    }

    private static String catAndMouse(int x, int y, int z) {
        int catA = Math.abs(x - z);
        int catB = Math.abs(y - z);
        return catA == catB ? "Mouse C" : (catA < catB ? "Cat A" : "Cat B");
    }
}
