package com.example.googleprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                int[] lastInterval = result.get(result.size() - 1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int [][] intervals={{1,2,3}, {4,5,6}};
        System.out.println(Arrays.toString(merge(intervals)));
    }
}
