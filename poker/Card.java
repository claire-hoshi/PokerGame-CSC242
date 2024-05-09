////////////////////////////////////////////////////////////////////////////////
// File: Card.java
// Course: CSC242, Spring Semester
// Authors: Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
//
////////////////////////////////////////////////////////////////////////////////

import java.util.HashMap;
import java.util.Map;

/**
 * The Card class represents a playing card with a rank and a suit.
 * Each card has an integer rank value and a string suit value.
 */
public class Card implements Comparable<Card> {
    private final CardUtils.Rank rank;
    private final String suit;

    // Map to store Rank enum to integer mapping
    private static final Map<CardUtils.Rank, Integer> RANK_MAP = new HashMap<>();

    static {
        for (CardUtils.Rank rank : CardUtils.Rank.values()) {
            RANK_MAP.put(rank, rank.getRankValue());
        }
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
    public Card(CardUtils.Rank rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Returns the rank of the card.
     *
     * @return the rank of the card
     */
    public CardUtils.Rank getRank() {
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
     * @return a negative integer, zero, or a positive integer as this card is less than, equal to, or greater than the specified card
     */
    @Override
    public int compareTo(Card otherCard) {
        return Integer.compare(this.getRankValue(), otherCard.getRankValue());
    }
}