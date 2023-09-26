package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortBySuitThenValue implements Comparator<Card> {

    private static final List<String> SUIT_ORDER = Arrays.asList("heart", "club", "diamond", "spade");
        @Override
        public int compare(Card a, Card b) {
            int suitIndex1 = SUIT_ORDER.indexOf(a.getSuit());
            int suitIndex2 = SUIT_ORDER.indexOf(b.getSuit());
            if( a.getSuit().equals(b.getSuit()) ) {
               return a.getValue() - b.getValue();
        }
            return Integer.compare(suitIndex1, suitIndex2);

    }
}