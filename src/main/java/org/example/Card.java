package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


class Card {
    public String suit;
    private String symbol;
    private int value;


    public Card(String suit, String symbol, int value) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static ArrayList<Card> initialiseDeck() {
        ArrayList<Card> deckOfCards = new ArrayList<>();

        List<String> suits = Arrays.asList("heart", "club", "diamond", "spade");
        List<String> symbols = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A");

        for (String suit : suits) {
            for (String symbol : symbols) {
                int value = getValue(symbol);
                Card card = new Card(suit, symbol, value);
                deckOfCards.add(card);
            }
        }

        return deckOfCards;
    }

    private static int getValue(String symbol) {
        switch (symbol) {
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
            default:
                return Integer.parseInt(symbol);
        }
    }

        @Override
        public String toString () {
            return symbol + " of " + suit + " its worth " + value;
        }
    }