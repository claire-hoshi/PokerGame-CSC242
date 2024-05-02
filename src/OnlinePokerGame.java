import java.util.ArrayList;
import java.util.List;

public class OnlinePokerGame {
    private List<Player> players;
    private int currentPlayerIndex;

    public OnlinePokerGame() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void startGame() {
        dealPrivateCards();
        showCommunityCards();
        determineWinner();
    }

    private void dealPrivateCards() {
        Deck deck = new Deck();
        deck.shuffle();

        // Deal 2 private cards to each player
        for (Player player : players) {
            Card[] privateCards = {deck.deal(), deck.deal()};
            player.setPrivateCards(privateCards);
        }
    }

    private void showCommunityCards() {
        Deck deck = new Deck();
        deck.shuffle();

        // Deal 3 community cards
        Card[] communityCards = new Card[5];
        for (int i = 0; i < 3; i++) {
            communityCards[i] = deck.deal();
        }

        // Show community cards
        System.out.println("Community Cards: " + communityCards[0].toString() + ", " 
                                                + communityCards[1].toString() + ", " 
                                                + communityCards[2].toString());

        // Deal and show the fourth community card
        communityCards[3] = deck.deal();
        System.out.println("Community Card: " + communityCards[3].toString());

        // Deal and show the fifth community card
        communityCards[4] = deck.deal();
        System.out.println("Community Card: " + communityCards[4].toString());
    }

    private Player determineWinner() {
        // Determine the winner based on the best hand
        Hand bestHand = null;
        Player winner = null;

        for (Player player : players) {
            Hand hand = new Hand();
            hand.evaluate(player.getPrivateCards());
            if (bestHand == null || hand.compareTo(bestHand) > 0) {
                bestHand = hand;
                winner = player;
            }
        }

        System.out.println("Winner: " + winner.getUsername() + " with hand: " + bestHand);

        return winner;
    }
}
