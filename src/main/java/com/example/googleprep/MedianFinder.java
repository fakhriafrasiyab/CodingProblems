package com.example.googleprep;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> lowerHalf;
    private PriorityQueue<Integer> upperHalf;

    MedianFinder() {
        lowerHalf = new PriorityQueue<>((a, b) -> b - a);

        upperHalf = new PriorityQueue<>();
    }

    public void addNumber(int num) {
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }

        if (lowerHalf.size() > upperHalf.size() + 1) {
//            System.out.println(lowerHalf.poll());
            upperHalf.add(lowerHalf.poll());
        } else if (upperHalf.size() > lowerHalf.size()) {
//            System.out.println(upperHalf.poll());
            lowerHalf.add(upperHalf.poll());
        }
    }

    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
        } else {
            return lowerHalf.peek();
        }
    }

    public static void main(String[] args) {

        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNumber(1);
        medianFinder.addNumber(2);
        medianFinder.addNumber(3);
        System.out.println(medianFinder.lowerHalf.peek());
        System.out.println(medianFinder.upperHalf.peek());
        System.out.println("Median: " + medianFinder.findMedian());

    }
}
