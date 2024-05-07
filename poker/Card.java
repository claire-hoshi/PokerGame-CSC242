import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    protected final String rank;
    protected final String suite;

    //constructor 
    public Card(String rank, String suit)
    {
      this.rank = rank;
      this.suit = suit;
    }
  
    public String getRank() {
        // Code to get rank
        return rank;
    }

    public String getSuit() {
        // Code to get suite
        return suit;
    }

    public int getRankValue()
    {
      //detect the string of the card to the integer 
      switch(rank){
        case "TWO": return 2;
        case "THREE": return 3;
        case "FOUR": return 4;
        case "FIVE": return 5;
        case "SIX": return 6;
        case "SEVEN": return 7;
        case "EIGHT": return 8;
        case "NINE": return 9;
        case "TEN": return 10;
        case "JACK": return 11;
        case "QUEEN": return 12;
        case "KING": return 13;
        case "ACE": return 14;
        default:
          throw new IllegalArguementException("Invalid Rank card:");
      }
    }
  public int compareTo(Card otherCard){
    return this.getRankValue() - otherCard.getRankValue(); //compare based on rank value
  }
}
