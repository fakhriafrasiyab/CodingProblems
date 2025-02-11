package com.example.tictactoe;

public class MergeArrays {

    public static void mergeArrays(int[] nums1, int m, int[] nums2, int n) {
        // Initialize indices for nums1, nums2, and merged array
        int i = m - 1; // Index for nums1
        int j = n - 1; // Index for nums2
        int k = m + n - 1; // Index for merged array

        // Merge arrays in descending order
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (j >= 0) {
            if (k<0){
                throw new IndexOutOfBoundsException("Index out of bounds in nums1");
            }
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        // Example usage
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        mergeArrays(nums1, m, nums2, n);

        // Print the merged array
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}

