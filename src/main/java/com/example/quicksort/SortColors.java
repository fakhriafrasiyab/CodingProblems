package com.example.quicksort;

public class SortColors {

    public void sort(int[] nums) {
        int mid = 0, low = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }

    }


    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //red  -- low -- 0s
    //white -- mid -- current
    //blue -- high -- 2s


    // later read these
//    void quickSort(int[] arr, int left, int right) {
//        if (left < right - 1) {
//            var pivot = left + right >> 1;
//            pivot = partition(arr, left, right, pivot);
//            quickSort(arr, left, pivot);
//            quickSort(arr, pivot+1, right);
//        }
//    }
//
//    int partition(int[] arr, int left, int right, int pivot) {
//        var pivotValue = arr[pivot];
//        swap(arr, pivot, --right);
//        for (int i = left; i < right; ++i) {
//            if (arr[i] < pivotValue) {
//                swap(arr, i, left++);
//            }
//        }
//        swap(arr, left, right);
//        return left;
//    }


}
