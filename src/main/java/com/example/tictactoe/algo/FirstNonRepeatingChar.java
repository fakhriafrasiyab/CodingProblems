package com.example.tictactoe.algo;

public class FirstNonRepeatingChar {
    public static char firstNonRepeatingChar(char[] arr) {
        int[] count = new int[256];  // Assuming ASCII character set
        for (char c : arr) {
            count[c]++;
        }

        for (char c : arr) {
            if (count[c] == 1) {
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args) {
        char[] arr = {'w', 's', 'w', 'i', 's', 's'};
        System.out.println(firstNonRepeatingChar(arr));  // Output: 'w'
    }
}
