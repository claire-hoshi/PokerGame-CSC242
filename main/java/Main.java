import java.util.ArrayList;
import java.util.List;

import poker.*;
  
public class Main {
    public static void main(String[] args) {
        OnlinePokerGame pokerGame = new OnlinePokerGame(); 
        pokerGame.addPlayer(new Player("Player 1"));
        pokerGame.addPlayer(new Player("Player 2"));
        pokerGame.startGame(2);
    }
}