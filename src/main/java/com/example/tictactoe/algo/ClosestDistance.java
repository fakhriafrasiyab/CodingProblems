package com.example.tictactoe.algo;

import java.util.Arrays;

public class ClosestDistance {
    public static int closestDistance(String text, String word1, String word2) {
        String[] words = text.split(" ");
        int minDistance = Integer.MAX_VALUE;
        int lastPosWord1 = -1;
        int lastPosWord2 = -1;
        System.out.println("text+ " + Arrays.toString(words));
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                lastPosWord1 = i;
                System.out.println("First One+ " + lastPosWord1);
                if (lastPosWord2 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(lastPosWord1 - lastPosWord2));
                }
            } else if (words[i].equals(word2)) {
                lastPosWord2 = i;
                System.out.println("Second One+ " + lastPosWord2);
                if (lastPosWord1 != -1) {
                    minDistance = Math.min(minDistance, Math.abs(lastPosWord1 - lastPosWord2));
                }
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    public static void main(String[] args) {
        String text = "the quick brown fox jumps over the lazy dog";
        String word1 = "quick";
        String word2 = "dog";
        System.out.println(closestDistance(text, word1, word2));  // Output: 7
    }
}