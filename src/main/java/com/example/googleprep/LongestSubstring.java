package com.example.googleprep;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstring {

    //lefti bir step saga surusdurur, duplicate-in oldugu axirinci indexi tapmir
    public static int lengthSubstring(String s) {
        HashSet<Character> characterHashSet = new HashSet<>();
        int left = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            if (characterHashSet.contains(s.charAt(right))) {
                characterHashSet.remove(s.charAt(left));
                left++;
            }
            characterHashSet.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthSubstring2("pwwkew"));
    }

    public static int lengthSubstring2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
