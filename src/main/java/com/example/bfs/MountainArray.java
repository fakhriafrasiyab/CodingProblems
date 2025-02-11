package com.example.bfs;

//      A mountain array is a sequence of numbers that:
//
//        First increases continuously up to a highest point (the peak).
//        After the peak, it decreases continuously.

//we will use bfs solution

public class MountainArray {
    public static int peakIndex(int[] arr) {
        int n = arr.length;
        int high = arr[n - 1];
        int low = arr[0];
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(arr[mid]<arr[mid+1]) low = mid+1;
            else high = mid;
        }

        return low;
    }
}
