package com.example.interview;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        HashSet uniqueVisitors = new HashSet<String>();

        uniqueVisitors.add("visitor1@example.com");
        uniqueVisitors.add("visitor2@example.com");
        uniqueVisitors.add("visitor1@example.com");

        System.out.println(uniqueVisitors.contains("visitor3@example.com"));
    }
}
