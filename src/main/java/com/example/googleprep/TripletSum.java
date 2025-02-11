package com.example.googleprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < length - 2; i++) {
            int right = length - 1;
            int left = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] data = {-1, -4, 4, 2, 1, 0, 4};
        //it is okay to see 0 multiple times so still result triplet will be unique combination.
        List<List<Integer>> lists = threeSum(data);
        System.out.println(lists);
    }
}
