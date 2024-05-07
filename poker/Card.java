public class Card {
    private final int rank;
    private final int suit;

    //constructor 
    public Card(int rank, int suit)
    {
      this.rank = rank;
      this.suit = suit;
    }
  
    public int getRank() {
        // Code to get rank
        return rank;
    }

    public int getSuite() {
        // Code to get suite
        return suite;
    }

    public int getRankValue()
    {
      //detect the string of the card to the integer 
      switch(rank){
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

   public int getSuitValue()
  {
    //detect string of the card to the integer 
    switch(suit)
      {
        case "SPADES": return 1;
        case "HEARTS": return 2;
        case "DIAMONDS": return 3;
        case "CLUBS": return 4;
      }
  }
  
    public int compareTo(Card otherCard){
    return this.getRankValue() - otherCard.getRankValue(); //compare based on rank value
  }
}
