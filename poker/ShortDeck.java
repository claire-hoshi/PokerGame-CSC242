public class ShortDeck extends Deck {
  public ShortDeck()
  {
    super(); //call constructor of Deck class
    removeLowCards(); //remove cards below 
  }

  private void removeLowCards(){
    List<Card> toRemove = new ArrayList<>();
    for(Card card: cards)
      {
        if(card.getRank().getValue() < Rank.SIX.getValue()){
          toRemove.add(card);
        }
      }
    cards.removeAll(toRemove);
  }

@Override //shuffle method
public void shuffle() {
  Collections.shuffle(cards);
}

//     public void reset() {
//         // Code to reset the deck

//     }

//     public void shuffle() {
//         // Code to shuffle the deck
//     }

//     public Card topCard() {
//         // Code to get the top card
//         return null;
//     }
// }
}