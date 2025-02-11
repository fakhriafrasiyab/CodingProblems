package com.example.newChapterInLife;

import java.util.HashSet;

public class LongestShit {

    public static void main(String[] args) {
        String s = "abcabcbb";
        String s2= "pwwkew";


        System.out.println(returnLength(s));
        System.out.println(returnLength(s2));
    }

    public static int returnLength(String s) {

        int left = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }


        return maxLength;
    }
}
