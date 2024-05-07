import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private String username;
    private Card[] hand;

    public Player(String username) {
        this.username = username;
        this.hand = new Card[2]; // Assuming each player starts with two hole cards
    }

    public void logIn() {
        // Placeholder code to log in
        System.out.println(username + " logged in.");
    }

    public void signUp() {
        // Placeholder code to sign up
        System.out.println(username + " signed up.");
    }

    public void joinTable() {
        // Placeholder code to join a table
        System.out.println(username + " joined a table.");
    }

    private void bet() {
        // Placeholder code for betting
        System.out.println(username + " placed a bet.");
    }

    public void revealHoleCards() {
        // Reveal hole cards
        System.out.println("Hole cards for " + username + ": " + hand[0] + ", " + hand[1]);
    }

    public String getUsername() {
        return username;
    }

    public void setHand(Card[] hand) {
        this.hand = hand;
    }
  
    public Card[] getHand(){
      
    }
  
    public int getCardNumber(){
      
    }

    // Method to evaluate and display the best hand
    public void evaluateHand(Card[] communityCards) {
        Card[] combinedCards = new Card[7]; // 2 hole cards + 5 community cards

        // Combine player's hole cards and community cards
        System.arraycopy(hand, 0, combinedCards, 0, 2);
        System.arraycopy(communityCards, 0, combinedCards, 2, 5);

        // Evaluate the best hand
        System.out.println("Best hand for " + getUsername() + ": " + bestHand);
    }
}


