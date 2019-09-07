package com.hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * designer-pdf-viewer
 */
public class DesignerPdfViewer {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] h = new int[26];
            String[] hItems = sc.nextLine().split(" ");
            for (int i = 0; i < 26; i++) {
                int hItem = Integer.parseInt(hItems[i]);
                h[i] = hItem;
            }
            String word = sc.nextLine();
            int result = designerPdfViewer(h, word);
            System.out.println(result);
        }
    }

    private static int designerPdfViewer(int[] h, String word) {
        int highestCharHeight = h[word.charAt(0) - 'a'];
        for (char c : word.toCharArray()) {
            if (h[c - 'a'] > highestCharHeight)
                highestCharHeight = h[c - 'a'];

        }
        return highestCharHeight * word.length();
    }
}
