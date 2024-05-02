public class Main {
    public static void main(String[] args) {
        // Create an online poker game instance
        OnlinePokerGame pokerGame = new OnlinePokerGame();

        // Add players to the game
        pokerGame.addPlayer(new Player("Player 1"));
        pokerGame.addPlayer(new Player("Player 2"));

        // Start the game
        pokerGame.startGame();
    }
}