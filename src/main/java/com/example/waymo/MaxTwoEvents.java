package com.example.waymo;

import java.util.Arrays;

public class MaxTwoEvents {

    public int maxTwoEvent(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int result = 0;
        int len = events.length;
        int[] maxValueAt = new int[len];
        int maxValue = 0;

        for (int i = 0; i < len; i++) {
            maxValue = Math.max(maxValue, events[i][2]);
            maxValueAt[i] = maxValue;
        }

        for (int[] event : events) {
            int currentValue = event[2];
            int lastIndex = bfsHelper(events, event[0]);
            int combinedValue = currentValue + (lastIndex >= 0 ? maxValueAt[lastIndex] : 0);
            result = Math.max(result, combinedValue);
        }
        return result;
    }


    public int bfsHelper(int[][] events, int target) {
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
        MaxTwoEvents mx = new MaxTwoEvents();
        int[][] events = {{1, 3, 2}, {4, 5, 2}, {2, 4, 3}};
        int[][] events2 = {{1, 3, 2}, {4, 5, 2}, {1, 5, 5}};
        int[][] events3 = {{1, 5, 3}, {1, 5, 1}, {6, 6, 5}};
        System.out.println(mx.maxTwoEvent(events));
        System.out.println(mx.maxTwoEvent(events2));
        System.out.println(mx.maxTwoEvent(events3));
    }
}
