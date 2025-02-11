package com.example.waymo;

import java.util.Arrays;

public class MaxTwoEvents2 {
    public static int maxTwoEvents(int[][] events) {
        // Sort events by their end time
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 0;
        int len = events.length;
        int[] maxValueAt = new int[len];
        int maxValue = 0;

        // Precompute the max single event value at each index
        for (int i = 0; i < len; i++) {
            maxValue = Math.max(maxValue, events[i][2]);
            maxValueAt[i] = maxValue;
        }

        // Calculate the maximum possible value for two non-overlapping events
        for (int i = 0; i < len; i++) {
            int currentValue = events[i][2];
            int lastIndex = binarySearch(events, events[i][0]);
            int combinedValue = currentValue + (lastIndex >= 0 ? maxValueAt[lastIndex] : 0);
            result = Math.max(result, combinedValue);
        }

        return result;
    }

    private static int binarySearch(int[][] events, int target) {
        int len = events.length;
        int low = 0, high = len - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (events[mid][1] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
        int[][] events1 = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        System.out.println(maxTwoEvents(events1)); // Expected output: 4
    }
}


