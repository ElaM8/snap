package org.example;

import java.util.*;
import java.util.stream.Collectors;


public class CardGame {
    public ArrayList<Card> deck;

    static Random random = new Random();

    public CardGame() {
        this.deck = Card.initialiseDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public Card dealedCard;
    private Card lastDealedCard;

    public Object dealCard() { // Object rather than Card, or create a deal outcome type to allow for the empty deck...
        if (deck.isEmpty()) {
            return "No more cards to deal";
        } else {
            int randomNumber = random.nextInt(deck.size());
//            System.out.println("random number from deal card is " + randomNumber );
            lastDealedCard = dealedCard;
            dealedCard = deck.get(randomNumber);
            deck.remove(randomNumber);
//            System.out.println("   this is the card dealed in game.dealCard " + dealedCard);
//            System.out.println("   this is the last card dealed " + lastDealedCard);
//            System.out.println("YOUR CARD IS " + dealedCard);
            checkPlayerWin(); // this has the null issue

//            if (lastDealedCard.getValue() != 0 && lastDealedCard != null) { checkPlayerWin(); } else { return dealedCard; }
            return dealedCard;
        }
    }

    public boolean checkPlayerWin() {
        if(lastDealedCard == null || dealedCard == null) {
            return false;
        } else if (lastDealedCard.getValue() == dealedCard.getValue()) {
//            System.out.println("last card check " + lastDealedCard);
//            System.out.println("last card value " + lastDealedCard.getValue());
//            System.out.println("dealed card check " + dealedCard);
//            System.out.println("dealed card value " + dealedCard.getValue());
            System.out.println("PLAYER WINS with " + lastDealedCard + " and " + dealedCard);
            System.exit(0);
            return true;
        } else if ((lastDealedCard.getValue() != dealedCard.getValue())) {
//            System.out.println("last card check " + lastDealedCard);
//            System.out.println("last card value " + lastDealedCard.getValue());
//            System.out.println("dealed card check " + dealedCard);
//            System.out.println("dealed card value " + dealedCard.getValue());
            System.out.println("PLAYER HASNT WON YET with " + lastDealedCard + " and " + dealedCard);
            return false;
        } else {
//            System.out.println("last card check " + lastDealedCard);
//            System.out.println("last card value " + lastDealedCard.getValue());
//            System.out.println("dealed card check " + dealedCard);
//            System.out.println("dealed card value " + dealedCard.getValue());
            System.out.println("SOMETHING WENT WRONG");
            return false;
        }
    }

    public ArrayList<Card> getLowestValueCards() {
//    deck.forEach(card -> System.out.println(card.getSuit()));
        int numberOrder = this.deck.stream()
                .mapToInt(card -> card.getValue())
                .min().getAsInt();
        return (ArrayList<Card>) this.deck.stream()
                .filter( card -> card.getValue() == numberOrder )
                .collect(Collectors.toList());
    }

    public ArrayList<Card> sortCopyOfDeck() {
        ArrayList<Card> sortedDeck = new ArrayList<>(deck);
        sortedDeck.sort(Comparator.comparingInt(Card::getValue));
        return sortedDeck;
    }

    public void sortDeckInNumberOrder() {
//        deck.sort(Comparator.comparingInt(card -> card.getValue()));
//        deck.sort(Comparator.comparingInt(Card::getValue));
//        deck.forEach((card -> System.out.println(card)));
//        deck.forEach((System.out::println));
        Collections.sort(deck, (a, b) -> a.getValue() - b.getValue());
        deck.forEach(card -> System.out.println(card));
        System.out.println(deck.size());
    }

    public void sortDeckIntoSuits() {
//        deck.sort(Comparator.comparing(card -> card.getSuit()));
//        Collections.sort(deck, (a, b) -> a.getSuit().compareTo(b.getSuit()));
        Collections.sort(deck, new SortBySuitThenValue());
        deck.forEach(card -> System.out.println(card));
        System.out.println(deck.size());
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
        deck.forEach(card -> System.out.println(card));
        System.out.println("the deck was shuffled and the current deck size is " + deck.size());
    }
    }
