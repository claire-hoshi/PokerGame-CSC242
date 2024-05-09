import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OnlinePokerGame pokerGame = new OnlinePokerGame();
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        int numberofplayer = 4;
        for (int i = 1; i <= numberofplayer; i++) {
            System.out.println("Enter username for Player " + i + ": ");
            String username = scanner.nextLine(); // Read user input for username
            pokerGame.addPlayer(new Player(username));
        }

        System.out.println("Welcome to Poker Game");
        pokerGame.startGame(numberofplayer);
    }
}