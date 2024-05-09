////////////////////////////////////////////////////////////////////////////////
// File:             OnlinePokerGame.java
// Course:           CSC242, Spring Semester
// Authors:          Claire Hoshi, Charlotte Zhao, Laura Bui, Lily Nguyen
//
////////////////////////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

/**
 * The OnlinePokerGame class represents an online poker game where multiple players can participate.
 * It implements the PokerGameInterface.
 */
public class OnlinePokerGame implements PokerGameInterface {
    private Player player; // Not sure what this variable is for; consider removing if unnecessary
    private List<Player> players; // List of players participating in the game
    private int currentPlayerIndex; // Index of the current player
    private Map<Player, Boolean> bets; // Map to store bets placed by players (true for winning, false for losing)

    /**
     * Constructs an OnlinePokerGame object with an empty list of players and an empty map of bets.
     */
    public OnlinePokerGame() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.bets = new HashMap<>();
    }

    /**
     * Adds a player to the game and logs them in.
     * 
     * @param player The player to add to the game
     */
    public void addPlayer(Player player) {
        if (players == null) {
            players = new ArrayList<>();
        }
        players.add(player);
        player.logIn();
    }

    /**
     * Removes a player from the game.
     * 
     * @param player The player to remove from the game
     */
    public void removePlayer(Player player) {
        boolean removed = players.remove(player);
        if (removed) {
            bets.remove(player);
            for (Map.Entry<Player, Boolean> entry : bets.entrySet()) {
                Player currentPlayer = entry.getKey(); 
                Boolean betStatus = entry.getValue();
                System.out.println(currentPlayer.getUsername() + " has been removed from the game.");
            }
        } else {
            System.out.println("Could not find " + player.getUsername() + " in the game.");
        }
    }

    /**
     * Starts the game with the specified number of players.
     * 
     * @param numberOfPlayers The number of players required to start the game
     */
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

    /**
     * Deals hands to all players in the game.
     */
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

    /**
     * Places a bet for the specified player.
     * 
     * @param playerUsername The username of the player placing the bet
     * @param willWin        True if the player will win, false otherwise
     */
    public void placeBet(String playerUsername, boolean willWin) {
        if (!isPlayerInGame(playerUsername)) {
            System.out.println(playerUsername + " is not part of the game.");
            return;
        }
        bets.put(players.get(currentPlayerIndex), willWin);
        System.out.println(playerUsername + " has placed a bet on " + (willWin ? "winning" : "losing"));
    }

    /**
     * Determines the winner of the game based on the players' hands.
     * 
     * @return The player with the winning hand
     */
    public Player determineWinner() {
        Hand bestHand = null;
        Player winner = null;

        if (!players.isEmpty()) {
            bestHand = new Hand(players.get(0).getPrivateCards());
            winner = players.get(0);
        } else {
            throw new IllegalArgumentException("No players in the game. Cannot determine a winner.");
        }

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

    /**
     * Checks if a player is in the game.
     * 
     * @param playerUsername The username of the player to check
     * @return True if the player is in the game, false otherwise
     */
    public boolean isPlayerInGame(String playerUsername){
        for (Player player : players) {
            if (player.getUsername().equals(playerUsername)) {
                return true;
            }
        }
        return false;
    }
}
