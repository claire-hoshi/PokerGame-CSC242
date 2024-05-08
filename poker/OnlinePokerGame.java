import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

interface PokerGameInterface{
    void addPlayer(Player player);
    void startGame(int numberOfPlayers);
    void dealHands();
    void placeBet(String playerUsername, boolean willWin);
    Player determineWinner();
    boolean isPlayerInGame(String playerUsername);
}

public class OnlinePokerGame implements PokerGameInterface {
    private List<Player> players;
    private int currentPlayerIndex;
    private Map<Player, Boolean> bets; // Change the type to Map<Player, Boolean>

    public OnlinePokerGame() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.bets = new HashMap<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(Player player) {
        boolean removed = players.remove(player);
        if (removed) {
            bets.remove(player);
            for (Map<Player, Boolean> betsByOthers : bets.values()) {
                betsByOthers.remove(player);
            }
            System.out.println(player.getUsername() + " has been removed from the game.");
        } else {
            System.out.println("Could not find " + player.getUsername() + " in the game.");
        }
    }

    public void startGame(int numberOfPlayers) { 
        dealHands();
    }

    public void dealHands() {
        Deck deck = new Deck();
        deck.shuffle();
        for (Player player : players) {
            Card[] privateCards = {deck.deal(), deck.deal()};
            player.setPrivateCards(privateCards);
        }
    }

    public void placeBet(String playerUsername, boolean willWin) {
        if (!isPlayerInGame(playerUsername)) {
            System.out.println(playerUsername + " is not part of the game.");
            return;
        }
        bets.put(players.get(currentPlayerIndex), willWin);
        System.out.println(playerUsername + " has placed a bet on " + (willWin ? "winning" : "losing"));
    }

    public Player determineWinner() {
        Hand bestHand = null;
        Player winner = null;
        for (Player player : players) {
            Card[] privateCards = player.getPrivateCards();
            // Combine privateCards with communityCards here before passing to Hand
            // Hand hand = new Hand(combinedCards);
            // Compare or evaluate hands...
        }
        System.out.println("Winner: " + winner.getUsername() + " with hand: " + bestHand);
        return winner;
    }

    public boolean isPlayerInGame(String playerUsername) {
        for (Player player : players) {
            if (player.getUsername().equals(playerUsername)) {
                return true;
            }
        }
        return false;
    }
}

