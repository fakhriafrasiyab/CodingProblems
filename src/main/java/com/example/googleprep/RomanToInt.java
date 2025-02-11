package com.example.googleprep;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static int romanToInt(String s) {
        Map<Character, Integer> numbers = new HashMap<>();
        numbers.put('I', 1);
        numbers.put('V', 5);
        numbers.put('X', 10);
        numbers.put('L', 50);
        numbers.put('C', 100);
        numbers.put('D', 500);
        numbers.put('M', 1000);
        int total = 0;
        int prevVal = 0;
        for (int i = 0; i < s.length(); i++) {
            int curVal = numbers.get(s.charAt(i));
            if (curVal > prevVal) {
                total += curVal - 2 * prevVal;
            } else {
                total += curVal;
            }
            prevVal = curVal;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
