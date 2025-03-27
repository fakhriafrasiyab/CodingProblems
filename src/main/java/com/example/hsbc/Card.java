package com.example.hsbc;

public class Card {
    Suite suite;
    Values value;

    public Card(Suite suite, Values value){
        this.suite = suite;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suite=" + suite +
                ", value=" + value +
                '}';
    }
}
