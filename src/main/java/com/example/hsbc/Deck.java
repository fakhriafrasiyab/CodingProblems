package com.example.hsbc;

import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class Deck {
    private Stack<Card> cardStack;

    public Deck() {
        cardStack = new Stack<>();
        initializeDeck();
    }

    private void initializeDeck() {
        for(Suite suite: Suite.values()) {
            for (Values value: Values.values()){
                cardStack.push(new Card(suite, value));
            }
        }
    }

    public Card draw () {
        if(cardStack.isEmpty()) {
            throw new IllegalStateException("Deck is empty!");
        }
        return cardStack.pop();
    }

    public void shuffle() {
        Random random = new Random();
        for(int i = cardStack.size()-1; i>0; i--){
            int j = random.nextInt(i+1);
            Card temp = cardStack.get(i);
            cardStack.set(i, cardStack.get(j));
            cardStack.set(j, temp);
        }
    }

    public int sizeOfDeck(){
        return cardStack.size();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardStack=" + cardStack +
                '}';
    }
}
