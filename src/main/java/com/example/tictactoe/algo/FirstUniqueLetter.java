package com.example.tictactoe.algo;

import java.util.Arrays;

public class FirstUniqueLetter {
    public static char firstUniqueLetter(String s) {
        int[] count = new int[256];  // Assuming ASCII character set
        for (char c : s.toCharArray()) {
            count[c]++;
            System.out.println(c + " " + count[c]);
        }
        System.out.println();

        for (char c : s.toCharArray()) {
            if (count[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        String s = "insiw";
        System.out.println(firstUniqueLetter(s));  // Output: 'w'
    }
}
