import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class OnlinePokerGameTest {

    @Test
    public void testAddPlayer() {
        OnlinePokerGame pokerGame = new OnlinePokerGame();
        Player player1 = new Player("1");
        Player player2 = new Player("2");

        pokerGame.addPlayer(player1);
        pokerGame.addPlayer(player2);

        assertTrue(pokerGame.isPlayerInGame("1"));
        assertTrue(pokerGame.isPlayerInGame("2"));
    }

    @Test
    public void testRemovePlayer() {
        OnlinePokerGame pokerGame = new OnlinePokerGame();
        Player player1 = new Player("1");
        Player player2 = new Player("2");

        pokerGame.addPlayer(player1);
        pokerGame.addPlayer(player2);

        pokerGame.removePlayer(player1);

        assertTrue(pokerGame.isPlayerInGame("2"));
    }

    @Test
    public void testDealHands() {
        OnlinePokerGame pokerGame = new OnlinePokerGame();
        Player player1 = new Player("1");

        pokerGame.addPlayer(player1);

        pokerGame.dealHands();

        assertEquals(5, player1.getCardNumber());
    }

    @Test
    public void testDetermineWinner() {
        OnlinePokerGame pokerGame = new OnlinePokerGame();
        Player player1 = new Player("1");
        Player player2 = new Player("2");

        pokerGame.addPlayer(player1);
        pokerGame.addPlayer(player2);

        player1.setPrivateCards(new Card[] {
            new Card(10, "HEARTS"),
            new Card(9, "HEARTS"),
            new Card(8, "HEARTS"),
            new Card(7, "HEARTS"),
            new Card(6, "HEARTS")
        });

        player2.setPrivateCards(new Card[] {
            new Card(10, "SPADES"),
            new Card(9, "SPADES"),
            new Card(8, "SPADES"),
            new Card(7, "SPADES"),
            new Card(6, "SPADES")
        });

        Player winner = pokerGame.determineWinner();

        assertEquals("1", winner.getUsername());
    }
}
