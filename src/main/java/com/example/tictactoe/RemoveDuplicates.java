package com.example.tictactoe;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {
        // Check for an empty array
        if (nums.length == 0) {
            return 0;
        }

        // Initialize a pointer for unique elements
        int k = 1;

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is different from the previous one, update the array
            if (nums[i] != nums[i - 1]) {
                System.out.println("k:    "+nums[k]);
//                System.out.println("i:    "+ nums[i]);
                nums[k++] = nums[i];
            }
        }

        // The value of k represents the count of unique elements in nums
        return k;
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5};

        int result = removeDuplicates(nums);

        // Print the modified array and the count of unique elements
        System.out.print("Modified Array: ");
        for (int i = 0; i < result; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\nCount of unique elements: " + result);
    }
}

