///////////////////////////////////////////////////////////////////////////
// File:             ShortDeck.java
// Course:           CSC242, Spring Semester
// Authors:          Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
///////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortDeck extends Deck {
    /**
     * Constructor for ShortDeck class.
     */
    public ShortDeck() {
        super(); 
        removeLowCards(); 
    }

    /**
     * Removes low cards from the deck.
     */
    private void removeLowCards() {
        List<Card> toRemove = new ArrayList<>();
        for (Card card : cards) {
            if (card.getRank() < Rank.SIX.ordinal()) {
                toRemove.add(card);
            }
        }
        cards.removeAll(toRemove);
    }

    /**
     * Overrides the shuffle method.
     */
    @Override 
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Rank enum with getRankValue() method.
     */
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int rankValue;

        Rank(int rankValue) {
            this.rankValue = rankValue;
        }

        public int getRankValue() {
            return rankValue;
        }
    }
}
