////////////////////////////////////////////////////////////////////////////////
// File: Deck.java
// Course: CSC242, Spring Semester
// Authors: Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
//
////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Deck class represents a deck of playing cards.
 * It provides methods for initializing the deck, shuffling the cards, and dealing cards.
 * This class utilizes the Card class to represent individual playing cards.
 */
public class Deck {
    // Instance variables
    protected final List<Card> cards;

    /**
     * Constructor for the Deck class.
     * Initializes a new deck of playing cards.
     */
    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    /**
     * Enumeration representing the suits of playing cards.
     */
    public enum Suit {
        HEARTS,
        DIAMONDS,
        CLUBS,
        SPADES;
    }

    /**
     * Initializes the deck with a standard set of 52 playing cards,
     * one for each combination of suit and rank.
     */
    public void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (CardUtils.Rank rank : CardUtils.Rank.values()) {
                cards.add(new Card(rank, suit.toString()));
            }
        }
        shuffle();
    }

    /**
     * Shuffles the deck by rearranging the order of cards randomly.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * Deals a card from the top of the deck.
     * If the deck is empty, prints an error message and returns null.
     *
     * @return The top card from the deck, or null if the deck is empty.
     */
    public Card deal() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Unable to deal a card.");
            return null;
        }
        return cards.remove(0);
    }
}