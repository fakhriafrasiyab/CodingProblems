package com.example.interview;

import java.util.Arrays;
import java.util.HashSet;

public class SetMismatch {
    public static int[] findErrorNums(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        int n = nums.length;
        int duplicate = -1;
//        int actualSum = 0;//2 ways to find actual sum of unique numbers.
        for (int num : nums) {
            if (seen.contains(num)) {
                duplicate = num;
            } else {
                seen.add(num);
//                actualSum+=num;
            }
        }
        int expectedSum = n * (n + 1) / 2;
        int actualSum = seen.stream().mapToInt(Integer::intValue).sum();
        int missing = expectedSum-actualSum;

        return new int [] {duplicate, missing};

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(nums)));
    }
}
