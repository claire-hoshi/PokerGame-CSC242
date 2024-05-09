////////////////////////////////////////////////////////////////////////////////
// File:             Card.java
// Course:           CSC242, Spring Semester
// Authors:          Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
//
////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;

/**
 * The Card class represents a playing card with a rank and a suit.
 * Each card has an integer rank value and a string suit value.
 */
public class Card {
    private final int rank;
    private final String suit;

    // Map to store rank string to integer mapping
    private static final Map<String, Integer> RANK_MAP = new HashMap<>();
    static {
        RANK_MAP.put("TWO", 2);
        RANK_MAP.put("THREE", 3);
        RANK_MAP.put("FOUR", 4);
        RANK_MAP.put("FIVE", 5);
        RANK_MAP.put("SIX", 6);
        RANK_MAP.put("SEVEN", 7);
        RANK_MAP.put("EIGHT", 8);
        RANK_MAP.put("NINE", 9);
        RANK_MAP.put("TEN", 10);
        RANK_MAP.put("JACK", 11);
        RANK_MAP.put("QUEEN", 12);
        RANK_MAP.put("KING", 13);
        RANK_MAP.put("ACE", 14);
    }

    // Map to store suit string to integer mapping
    private static final Map<String, Integer> SUIT_MAP = new HashMap<>();
    static {
        SUIT_MAP.put("SPADES", 1);
        SUIT_MAP.put("HEARTS", 2);
        SUIT_MAP.put("DIAMONDS", 3);
        SUIT_MAP.put("CLUBS", 4);
    }

    /**
     * Constructs a card with the specified rank and suit.
     *
     * @param rank the rank of the card
     * @param suit the suit of the card
     */
    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank of the card
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns the suit of the card.
     *
     * @return the suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Returns the integer value of the rank.
     *
     * @return the integer value of the rank
     * @throws IllegalArgumentException if the rank is invalid
     */
    public int getRankValue() {
        Integer rankValue = RANK_MAP.get(rank);
        if (rankValue == null) {
            throw new IllegalArgumentException("Invalid Rank card: " + rank);
        }
        return rankValue;
    }

    /**
     * Returns the integer value of the suit.
     *
     * @return the integer value of the suit
     * @throws IllegalArgumentException if the suit is invalid
     */
    public int getSuitValue() {
        Integer suitValue = SUIT_MAP.get(suit);
        if (suitValue == null) {
            throw new IllegalArgumentException("Invalid Suit card: " + suit);
        }
        return suitValue;
    }

    /**
     * Compares this card with another card based on rank.
     *
     * @param otherCard the other card to compare
     * @return the value if this card is equal to the other card;
     *         a value less than if the card is lower ranked than the other card;
     *         and a value greater than if the card is higher ranked than the other card
     */
    public int compareTo(Card otherCard) {
        return Integer.compare(this.getRankValue(), otherCard.getRankValue());
    }
}

