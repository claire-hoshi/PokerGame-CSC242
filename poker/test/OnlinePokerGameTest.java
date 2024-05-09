import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class OnlinePokerGameTest {
    @Test
    public void testDetermineWinner() {
        OnlinePokerGame game = new OnlinePokerGame();
        Player player1 = new Player("Player1");
        Player player2 = new Player("Player2");
        game.addPlayer(player1);
        game.addPlayer(player2);

        Card[] player1Cards = {
            new Card(CardUtils.Rank.TEN, "HEARTS"),
            new Card(CardUtils.Rank.NINE, "HEARTS"),
            new Card(CardUtils.Rank.EIGHT, "HEARTS"),
            new Card(CardUtils.Rank.SEVEN, "HEARTS"),
            new Card(CardUtils.Rank.SIX, "HEARTS")
        };
        player1.setPrivateCards(player1Cards);

        Card[] player2Cards = {
            new Card(CardUtils.Rank.TEN, "SPADES"),
            new Card(CardUtils.Rank.NINE, "SPADES"),
            new Card(CardUtils.Rank.EIGHT, "SPADES"),
            new Card(CardUtils.Rank.SEVEN, "SPADES"),
            new Card(CardUtils.Rank.SIX, "SPADES")
        };
        player2.setPrivateCards(player2Cards);

        game.startGame(2);

        Player winner = game.determineWinner();
        assertEquals(player1, winner);
    }
}