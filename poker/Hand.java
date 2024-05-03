public class Hand {
    private Card[] cards;

    public Hand(Card[] cards){
      if(cards.length != 5)
      {
        throw new IllegalArgumentException("Hand must contains 5 cards");
      }
      this.cards = cards;
      Arrays.sort(this.cards); //sort to make easier for running
    }
  
    public String evaluate() {
        // Code to evaluate the hand
        if(isFourOfAKind())
        {
          return "Four of A Kind";
        }

      if(isStraightFlush())
      {
        return "Straight Flush";
      }
    return "High Card";
    }

    private boolean isFourOfAKind()
    {
      int rankCount = 0;
      int currentRank = cards[0].getRankValue();
      for(Card cards: cards)
        {
          if(card.getRankValue() == currentRank) //check if is the same value 
          {
            rankCount++;
          }
          else{
            currentRank = card.getRankValue();
            rankCount = 1;
          }
          if(rankCount == 4)
          {
            return true;
          }
        }
      return false;
    }
  
  private boolean isStraightFlush() {
    if (!isFlush()) {
      return false;
    }

    int currentRank = cards[0].getRankValue();
    int consecutive = 1;
    for (int i = 1; i < cards.length; i++) {
      if (cards[i].getRankValue() == currentRank + 1) {
        consecutive++;
        currentRank++;
      } else {
        consecutive = 1;
        currentRank = cards[i].getRankValue();
      }
      if (consecutive == 5) {
        return true;
      }
    }
    return false;
  }

    private boolean isFlush() {  // Check if all cards have the same suit
    String suit = cards[0].getSuit();
    for (Card card : cards) {
      if (!card.getSuit().equals(suit)) {
        return false;
      }
    }
    return true;
  }

  private boolean isFullHouse()
  {
    int rankCount1 = 0;
    int rankCount2 = 0;
    int currentRank = cards[0].getRankValue();

    for(Card card: cards){
      if(card.getRankValue() == currentRank)
      {
        rankCount1++;
      }
      else{
        currentRank = card.getRankValue();
        rankCount2 = 1;
      }
    }

    return(rankCount1 == 3 && rankCount2 == 2) || (rankCount1 == 2 && rankCount2 == 3);
  }
    
    // public int compareTo(Hand otherHand) {
    //     // Code to compare hands
    //     return 0;
    // }
}
