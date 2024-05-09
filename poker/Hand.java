////////////////////////////////////////////////////////////////////////////////
// File:             Hand.java
// Course:           CSC242, Spring Semester
// Authors:          Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
//
////////////////////////////////////////////////////////////////////////////////

import java.util.Arrays;

/**
 * The Hand class represents a hand of cards in a card game.
 * It provides methods to evaluate the hand and compare hands.
 * Hands must contain exactly 5 cards.
 */
public class Hand implements Comparable<Hand> {
    private Card[] cards;

    /**
     * Constructs a hand with the given array of cards.
     *
     * @param cards the array of cards representing the hand
     * @throws IllegalArgumentException if the number of cards is not exactly 5
     */
    public Hand(Card[] cards) {
        if (cards.length != 5) {
            throw new IllegalArgumentException("Hand must contain 5 cards");
        }
        this.cards = cards;
        Arrays.sort(this.cards); // sort to make it easier for running
    }

    /**
     * Evaluates the hand and returns a string representing its rank.
     *
     * @return a string representing the rank of the hand
     */
    public String evaluate() {
        // Code to evaluate the hand
        if (isFourOfAKind()) {
            return "Four of A Kind";
        }

        if (isStraightFlush()) {
            return "Straight Flush";
        }
        // Add other hand evaluations as needed
        return "High Card";
    }

    /**
     * Checks if the hand contains four cards of the same rank.
     *
     * @return true if the hand contains four of a kind, false otherwise
     */
    private boolean isFourOfAKind() {
        int rankCount = 0;
        int currentRank = cards[0].getRankValue();
        for (Card card : cards) {
            if (card.getRankValue() == currentRank) { // check if it is the same value
                rankCount++;
            } else {
                currentRank = card.getRankValue();
                rankCount = 1;
            }
            if (rankCount == 4) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the hand contains Straight Flush.
     *
     * @return true if the hand contains a straight flush, false otherwise
     */
    private boolean isStraightFlush() {
        if (!isFlush()) {
            return false;
        }

        int currentRank = cards[0].getRankValue();
        int consecutive = 1;
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getRankValue() == currentRank + 1) {
                consecutive++;
                currentRank++;
            } else {
                consecutive = 1;
                currentRank = cards[i].getRankValue();
            }
            if (consecutive == 5) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the hand contains Flush.
     *
     * @return true if all cards have the same suit, false otherwise
     */
    private boolean isFlush() {
        String suit = cards[0].getSuit();
        for (Card card : cards) {
            if (!card.getSuit().equals(suit)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the hand contains isFullHouse
     *
     * @return true if the hand contains a full house, false otherwise
     */
    private boolean isFullHouse() {
        int rankCount1 = 0;
        int rankCount2 = 0;
        int currentRank = cards[0].getRankValue();

        for (Card card : cards) {
            if (card.getRankValue() == currentRank) {
                rankCount1++;
            } else {
                currentRank = card.getRankValue();
                rankCount2 = 1;
            }
        }

        return (rankCount1 == 3 && rankCount2 == 2) || (rankCount1 == 2 && rankCount2 == 3);
    }

    /**
     * Compares this hand with another hand based on their ranks.
     *
     * @param otherHand the other hand to compare with
     * @return a negative integer, zero, or a positive integer as this hand is less than, equal to, or greater than the specified hand
     */
    @Override
    public int compareTo(Hand otherHand) {
        // Compare hands based on their ranks
        return Integer.compare(this.evaluate().compareTo(otherHand.evaluate()), 0);
    }
}

