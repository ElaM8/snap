package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name = "PlayerName";

    private List<Card> playerHand;
    // for checking the win later - the hand will be their own current card and the previous card

    public Player(String name) {
        this.name = name;
        this.playerHand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void addCardToHand(Card card) {
        if (card != null) {
            this.playerHand.add(card);
        } else {
            System.out.println("card is null");
        }
    }


}

// interface to define turn?