import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        // Create standard 52-card deck
        for (CardSuit suit : CardSuit.values()) {
            for (CardRank rank : CardRank.values()) {
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

    //method return suit value
    public static String[] getSuitValues(){ 
      return new String[] {"SPADES", "HEARTS", "DIAMONDS", "CLUBS"};
    }
    //method return rank value
    public static String[] getRankValues(){
      return new Srtring[] {"SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
    }
}

