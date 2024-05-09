import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

interface PokerGameInterface{
    void addPlayer(Player player);
    void startGame(int numberOfPlayers);
    void dealHands();
    void placeBet(String playerUsername, boolean willWin);
    Player determineWinner();
    boolean isPlayerInGame(String playerUsername);
}

public class OnlinePokerGame implements PokerGameInterface {
    private Player player;
    private List<Player> players;
    private int currentPlayerIndex;
    private Map<Player, Boolean> bets; 

    public OnlinePokerGame() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.bets = new HashMap<>();
    }

    public void addPlayer(Player player) {
    if (players == null) {
        players = new ArrayList<>();
    }
        players.add(player);
        player.logIn();
    }

    public void removePlayer(Player player) {
        boolean removed = players.remove(player);
        if (removed) {
            bets.remove(player);
            for (Map.Entry<Player, Boolean> entry : bets.entrySet()) {
                Player currentPlayer = entry.getKey(); 
                // Changed variable name from player to currentPlayer
                Boolean betStatus = entry.getValue();

                System.out.println(currentPlayer.getUsername() + " has been removed from the game.");
            }
        } else {
            System.out.println("Could not find " + player.getUsername() + " in the game.");
        }
    }

    public void startGame(int numberOfPlayers) {
        if (players.size() != numberOfPlayers) {
            System.out.println("Not enough players to start the game.");
            return;
        }

        dealHands();

        for (Player player : players) {
            placeBet(player.getUsername(), true); 
        }

        determineWinner();
    }

    public void dealHands() {
        Deck deck = new Deck();
        deck.shuffle();
        for (Player player : players) {
            Card[] privateCards = new Card[5]; 
            for (int i = 0; i < 5; i++) {
                privateCards[i] = deck.deal(); 
            }
            player.setPrivateCards(privateCards);
            player.setHand(Arrays.asList(privateCards)); 
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
        // Iterate over the players to find the winner
        Hand bestHand = null;
        Player winner = null;

        // Initialize the best hand and winner with the first player
        if (!players.isEmpty()) {
            bestHand = new Hand(players.get(0).getPrivateCards());
            winner = players.get(0);
        } else {
            throw new IllegalArgumentException("No players in the game. Cannot determine a winner.");
        }

        // Iterate over the remaining players to compare hands
        for (int i = 1; i < players.size(); i++) {
            Hand currentHand = new Hand(players.get(i).getPrivateCards());
            if (currentHand.compareTo(bestHand) > 0) {
                bestHand = currentHand;
                winner = players.get(i);
            }
        }

        System.out.println("Winner: " + winner.getUsername() + " with hand: " + bestHand.evaluate());
        return winner;
    }
    
    public boolean isPlayerInGame(String playerUsername){
        for (Player player : players) {
            if (player.getUsername().equals(playerUsername)) {
                return true;
            }
        }
        return false;
    }
}
