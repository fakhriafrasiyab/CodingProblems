package com.example.googleprep;

import java.util.HashSet;
import java.util.Set;

public class PairWithSum {
    public static boolean hasPairWithSum(int[] data, int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int value : data) {
            System.out.println(sum-value);
            if (complements.contains(value)) {
                return true;
            }
            complements.add(sum - value);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 1, 4};
        int sum = 8;
        boolean result = hasPairWithSum(data, sum);
        System.out.println(result);
    }
}
