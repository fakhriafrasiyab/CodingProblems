package com.example.googleprep;

public class SumOfIntegers {
    public static int getSum(int a, int b) {
        while(b!=0){
            //find carry
            int carry = a & b;
            //addition without carry
            a=a^b;
            //left carry to the left until there is no carry
            b=carry<<1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println("SUM is: " + getSum(5, 3));
    }
}
