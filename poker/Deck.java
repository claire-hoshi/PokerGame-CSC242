import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    protected final List<Card> cards;

    private int rank;
    private String suit;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    public enum Suit { 
        HEARTS, 
        DIAMONDS, 
        CLUBS, 
        SPADES;
    }

    public enum Rank {
        ACE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING
    }

    public void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle(); 
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card deal() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Unable to deal a card.");
            return null;
        }
        return cards.remove(0); // Deal the top card (first card in the list)
    }
}
