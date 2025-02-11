package com.example.googleprep;

import java.util.Arrays;

public class TwoSumInputSorted {
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int length = numbers.length;
        int right = length - 1;
        int sum;
        while (left < right) {
            sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        throw new IllegalArgumentException("Solution couldn't be found");
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int target = 4;
        System.out.println("Indexes of numbers " + Arrays.toString(twoSum(numbers, target)));
    }
}
