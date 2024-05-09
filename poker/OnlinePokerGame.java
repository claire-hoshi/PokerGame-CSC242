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
        players.add(player);
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
        dealHands();
        placeBet(players.get(0).getUsername(), true);
        determineWinner();
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
            if (player != null) {
                String playerUsername = player.getUsername();
            } else {
                throw new IllegalArgumentException("Player is null. Cannot determine a winner.");
            }
            Hand bestHand = null;
            Player winner = null;
            for (Player player : players) {
                Card[] privateCards = player.getPrivateCards();
                // Logic to determine the best hand and winner
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
