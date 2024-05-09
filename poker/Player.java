import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String username;
    private List<Card> hand;
    private Card[] privateCards;

    public Player(String username) {
        this.username = username;
        this.hand = new ArrayList<>(); //ArrayList to store cards
    }

    public void logIn() {
        System.out.println(username + " logged in.");
    }

    public String getUsername() {
        return username;
    }

    public void setHand(List<Card> hand) {
        this.hand = hand;
    }

    public Card[] getHand() {
        // Convert the List<Card> to Card[] and return it
        return hand.toArray(new Card[0]);
    }

    public int getCardNumber() {
        return hand.size();
    }

    public void setPrivateCards(Card[] privateCards) {
        this.privateCards = privateCards;
    }

    public Card[] getPrivateCards() {
        return privateCards;
    }

    public void evaluateHand(Card[] communityCards) {
        Card[] combinedCards = new Card[7]; // 2 hole cards + 5 community cards

        // Combine player's hole cards and community cards
        System.arraycopy(hand.toArray(), 0, combinedCards, 0, 2);
        System.arraycopy(communityCards, 0, combinedCards, 2, 5);
    }
}
