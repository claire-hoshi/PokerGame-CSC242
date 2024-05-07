import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import poker.CardSuit;
//import poker.CardRank;

public class Deck {
    protected final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    public void initializeDeck() {
        // Create standard 52-card deck
        Card card = new Card(rank, suit); // Create an instance of Card to access non-static methods
        for (String suit : card.getSuitValues()) {
            for (String rank : card.getRankValues()) {
                cards.add(new Card(rank, suit));
            }
        }
        shuffle(); // Shuffle the deck after initialization
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