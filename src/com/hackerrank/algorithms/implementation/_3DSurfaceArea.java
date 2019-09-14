package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

import static java.lang.Math.max;

/**
 * 3d-surface-area
 */
public class _3DSurfaceArea {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] HW = sc.nextLine().split(" ");
            int H = Integer.parseInt(HW[0]);
            int W = Integer.parseInt(HW[1]);
            int[][] A = new int[H][W];
            for (int i = 0; i < H; i++) {
                String[] ARowItems = sc.nextLine().split(" ");
                sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                for (int j = 0; j < W; j++) {
                    int AItem = Integer.parseInt(ARowItems[j]);
                    A[i][j] = AItem;
                }
            }
            int result = surfaceArea(A, H, W);
            System.out.println(result);
        }
    }

    /**
     * Top and bottom surface area would be fully uncovered.
     * So W * H for top surface area and another W * H for bottom surface area.
     *
     * @param a Array
     * @param h Height of Array a
     * @param w Width of Array a
     * @return Total surface area
     */
    private static int surfaceArea(int[][] a, int h, int w) {
        int area = 2 * h * w;
        for (int hid = 0; hid < h; hid++) {
            for (int wid = 0; wid < w; wid++) {
                // up
                area += max(0, a[hid][wid] - (hid - 1 >= 0 ? a[hid - 1][wid] : 0));
                // down
                area += max(0, a[hid][wid] - (hid + 1 < h ? a[hid + 1][wid] : 0));
                // left
                area += max(0, a[hid][wid] - (wid - 1 >= 0 ? a[hid][wid - 1] : 0));
                // right
                area += max(0, a[hid][wid] - (wid + 1 < w ? a[hid][wid + 1] : 0));
            }
        }
        return area;
    }
}
