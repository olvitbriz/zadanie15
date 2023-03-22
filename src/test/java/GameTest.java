import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Game;
import ru.netology.NotFoundException;
import ru.netology.Player;

public class GameTest {

    @Test
    public void firstPlayerStronger() {
        Game game = new Game();

        Player player1 = new Player(1, "Коля", 100);
        Player player2 = new Player(2, "Антон", 50);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Коля", "Антон");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerStronger() {
        Game game = new Game();

        Player player1 = new Player(1, "Коля", 100);
        Player player2 = new Player(2, "Антон", 150);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Коля", "Антон");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void equalsStrongerPlayers() {
        Game game = new Game();

        Player player1 = new Player(1, "Коля", 50);
        Player player2 = new Player(2, "Антон", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Коля", "Антон");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegister() {
        Game game = new Game();

        Player player1 = new Player(1, "Коля", 100);
        Player player2 = new Player(2, "Антон", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Петя", "Антон"));
    }

    @Test
    public void secondPlayerNotRegister() {
        Game game = new Game();

        Player player1 = new Player(1, "Коля", 100);
        Player player2 = new Player(2, "Антон", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Коля", "Петя"));
    }

    @Test
    public void twoPlayersNotRegister() {
        Game game = new Game();

        Player player1 = new Player(1, "Коля", 100);
        Player player2 = new Player(2, "Антон", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, () -> game.round("Петя", "Витя"));
    }
}
