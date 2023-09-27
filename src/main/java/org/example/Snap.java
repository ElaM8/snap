package org.example;

import java.util.ArrayList;
import java.util.List;

public class Snap extends CardGame {

    public List<Player> players = new ArrayList<>();

    public Snap() {
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayerIndex(Player player) {
        return players.indexOf(player);
    }

    @Override
    public Object dealCard(int playerIndex) { // Object rather than Card, or create a deal outcome type to allow for the empty deck...
        if (deck.isEmpty()) {
            return "No more cards to deal";
        } else {
            int randomNumber = random.nextInt(deck.size());
            Card lastDealedCard = dealedCard; // local not inherited
            dealedCard = deck.get(randomNumber);
            deck.remove(randomNumber);

            if (playerIndex >= 0 && playerIndex < players.size()) {
                Player player = players.get(playerIndex);
                player.addCardToHand(dealedCard);
//                System.out.println("THIS IS THE HAND FOR " + player.getName() + " " + player.getPlayerHand());
            } else {
                System.out.println("This player has an invalid player index");
                return "This player has an invalid player index";
            }  // move/separate validate player index
//            System.out.println("This is the playerIndex " + playerIndex + " and the dealed card " + dealedCard);
            return dealedCard;
        }
    }

    @Override
    public Object checkPlayerWin(int playerIndex) {
        Player currentPlayer = players.get(playerIndex);
        for (int i = 0; i < players.size(); i++) {
            if (i != playerIndex) {
                Player otherPlayer = players.get(i);
                List<Card> otherPlayerHand = otherPlayer.getPlayerHand();
                if (!otherPlayerHand.isEmpty()) {
                    Card lastCardInHand = otherPlayerHand.get(otherPlayerHand.size() - 1);
                    if (lastCardInHand.getValue() == dealedCard.getValue()) {
                        System.out.println("SNAP!! " + otherPlayer.getName() + " WINS with " + lastCardInHand + " and " + dealedCard);
                        System.exit(0);
                        return true;
                    }
                }
            }
        }

        System.out.println("NO WIN");
        return false;
    }
}
