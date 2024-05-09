////////////////////////////////////////////////////////////////////////////////
// File: ShortDeck.java
// Course: CSC242, Spring Semester
// Authors: Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
////////////////////////////////////////////////////////////////////////////////

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
            if (card.getRank().ordinal() < CardUtils.Rank.SIX.ordinal()) {
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
}