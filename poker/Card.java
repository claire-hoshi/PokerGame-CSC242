import java.util.HashMap;
import java.util.Map;

public class Card {
    private final int rank;
    private final String suit;

    // Map to store rank string to integer mapping
    private static final Map<String, Integer> RANK_MAP = new HashMap<>();
    static {
        RANK_MAP.put("TWO", 2);
        RANK_MAP.put("THREE", 3);
        RANK_MAP.put("FOUR", 4);
        RANK_MAP.put("FIVE", 5);
        RANK_MAP.put("SIX", 6);
        RANK_MAP.put("SEVEN", 7);
        RANK_MAP.put("EIGHT", 8);
        RANK_MAP.put("NINE", 9);
        RANK_MAP.put("TEN", 10);
        RANK_MAP.put("JACK", 11);
        RANK_MAP.put("QUEEN", 12);
        RANK_MAP.put("KING", 13);
        RANK_MAP.put("ACE", 14);
    }

    // Map to store suit string to integer mapping
    private static final Map<String, Integer> SUIT_MAP = new HashMap<>();
    static {
        SUIT_MAP.put("SPADES", 1);
        SUIT_MAP.put("HEARTS", 2);
        SUIT_MAP.put("DIAMONDS", 3);
        SUIT_MAP.put("CLUBS", 4);
    }

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getRankValue() {
        Integer rankValue = RANK_MAP.get(rank);
        if (rankValue == null) {
            throw new IllegalArgumentException("Invalid Rank card: " + rank);
        }
        return rankValue;
    }

    public int getSuitValue() {
        Integer suitValue = SUIT_MAP.get(suit);
        if (suitValue == null) {
            throw new IllegalArgumentException("Invalid Suit card: " + suit);
        }
        return suitValue;
    }

    public int compareTo(Card otherCard) {
        return Integer.compare(this.getRankValue(), otherCard.getRankValue());
    }
}
