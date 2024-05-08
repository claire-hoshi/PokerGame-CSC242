import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortDeck extends Deck {
    public ShortDeck() {
        super(); // Call constructor of Deck class
        removeLowCards(); // Remove cards below rank six
    }

    private void removeLowCards() {
        List<Card> toRemove = new ArrayList<>();
        for (Card card : cards) {
            if (card.getRank().getRankValue() < Rank.SIX.getRankValue()) {
                toRemove.add(card);
            }
        }
        cards.removeAll(toRemove);
    }

    @Override // Override shuffle method
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Define the Rank enum with getRankValue() method
    public enum Rank {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
        JACK(11), QUEEN(12), KING(13), ACE(14);

        private final int rankValue;

        Rank(int rankValue) {
            this.rankValue = rankValue;
        }

        public int getRankValue() {
            return rankValue;
        }
    }
}
