package com.example.tictactoe.algo;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumberCustomSort {

    public static String formLargestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];

        // Convert numbers to strings
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        // Sort the array using custom logic (Insertion Sort)
        insertionSort(numStrs);

        // If the largest number is "0", return "0"
        if (numStrs[0].equals("0")) {
            return "0";
        }

        // Concatenate all numbers to form the largest number
        StringBuilder result = new StringBuilder();
        for (String numStr : numStrs) {
            result.append(numStr);
        }

        return result.toString();
    }

    private static void insertionSort(String[] numStrs) {
        int n = numStrs.length;

        for (int i = 1; i < n; i++) {
            String key = numStrs[i];
            int j = i - 1;

            // Compare and shift elements to the right position
            while (j >= 0 && (numStrs[j] + key).compareTo(key + numStrs[j]) < 0) {
                numStrs[j + 1] = numStrs[j];
                j = j - 1;
            }
            numStrs[j + 1] = key;
        }
    }

    public static String largestNumber(String[] nums) {
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));
        if (nums[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String [] nums = {"3", "30", "34", "5", "9"};
        System.out.println("Largest possible number: " + largestNumber(nums));
    }
}
