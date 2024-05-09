///////////////////////////////////////////////////////////////////////////
// File:             Player.java
// Course:           CSC242, Spring Semester
// Authors:          Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
///////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;

/**
 * Constructor for Player class.
 * @param username The username of the player.
 */
public class Player {
    private String username;
    private List<Card> hand;
    private Card[] privateCards;

    public Player(String username) {
        this.username = username;
        this.hand = new ArrayList<>(); //ArrayList to store cards
    }
    /**
         * Logs in the player.
         */
        public void logIn() {
            System.out.println(username + " logged in.");
        }

        /**
         * Gets the username of the player.
         * @return The username.
         */
        public String getUsername() {
            return username;
        }

        /**
         * Sets the hand of the player.
         * @param hand The list of cards in the hand.
         */
        public void setHand(List<Card> hand) {
            this.hand = hand;
        }

        /**
         * Gets the hand of the player.
         * @return The list of cards in the hand.
         */
        public Card[] getHand() {
            return hand.toArray(new Card[0]);
        }

        /**
         * Gets the number of cards in the hand.
         * @return The number of cards.
         */
        public int getCardNumber() {
            return hand.size();
        }

        /**
         * Sets the private cards of the player.
         * @param privateCards The private cards.
         */
        public void setPrivateCards(Card[] privateCards) {
            this.privateCards = privateCards;
        }

        /**
         * Gets the private cards of the player.
         * @return The private cards.
         */
        public Card[] getPrivateCards() {
            return privateCards;
        }

        /**
         * Evaluates the hand of the player.
         * @param communityCards The community cards on the table.
         */
        public void evaluateHand(Card[] communityCards) {
            Card[] combinedCards = new Card[7]; 

            System.arraycopy(hand.toArray(), 0, combinedCards, 0, 2);
            System.arraycopy(communityCards, 0, combinedCards, 2, 5);
        }
    }
