package org.example;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;

    private List<Card> playerHand;

    public Player(String name) {
        this.name = name;
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

    public void addCard(Card card) {
        this.playerHand.add(card);
    }
}

// interface to define turn?