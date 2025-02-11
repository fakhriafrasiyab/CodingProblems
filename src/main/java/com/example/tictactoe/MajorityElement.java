package com.example.tictactoe;

public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
            }

            count += (nums[i] == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {3, 3, 3, 2, 4, 4, 2, 4, 4};

        int result = majorityElement(nums);

        System.out.println("Majority Element: " + result);
    }
}

