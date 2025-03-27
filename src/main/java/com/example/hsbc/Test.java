package com.example.hsbc;

public class Test {

    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println(deck);
        System.out.println(deck.sizeOfDeck());
        deck.shuffle();
        System.out.println(deck);
        System.out.println(deck.sizeOfDeck());
        deck.shuffle();
        System.out.println(deck);
        System.out.println(deck.sizeOfDeck());
    }
}
