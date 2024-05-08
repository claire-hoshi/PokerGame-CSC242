import java.util.ArrayList;
import java.util.List;

public class Player {
    private String username;
    private List<Card> hand;
    private Card[] privateCards;

    public Player(String username) {
        this.username = username;
        this.hand = new ArrayList<>(); // Using ArrayList to store cards
    }

    public void logIn() {
        System.out.println(username + " logged in.");
    }

    public void signUp() {
        System.out.println(username + " signed up.");
    }

    public void joinTable() {
        System.out.println(username + " joined a table.");
    }

    public void revealHoleCards() {
        System.out.println("Hole cards for " + username + ": " + hand.get(0) + ", " + hand.get(1));
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
