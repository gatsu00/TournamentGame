package Game;
import Game.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class GameTest {

    @Test
    public void whenFirstPlayerWin() {
        Player Petr = new Player(1, "Petr", 130);
        Player Ivan = new Player(2, "Ivan", 110);
        Game game = new Game();

        game.register(Ivan);
        game.register(Petr);
        int actual = game.round("Petr", "Ivan");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenSecondPlayerWin() {
        Player Petr = new Player(1, "Petr", 130);
        Player Ivan = new Player(2, "Ivan", 140);
        Game game = new Game();

        game.register(Ivan);
        game.register(Petr);
        int actual = game.round("Petr", "Ivan");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstAndSecondPlayerEquals() {
        Player Petr = new Player(1, "Petr", 130);
        Player Ivan = new Player(2, "Ivan", 130);
        Game game = new Game();

        game.register(Ivan);
        game.register(Petr);
        int actual = game.round("Petr", "Ivan");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void whenFirstPlayerNotExist() {
        Player Petr = new Player(1, "Petr", 150);
        Player Ivan = new Player(2, "Ivan", 130);
        Game game = new Game();

        game.register(Ivan);
        game.register(Petr);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Kolya", "Ivan")
        );
    }

    @Test
    public void whenSecondPlayerNotExist() {
        Player Petr = new Player(1, "Petr", 150);
        Player Ivan = new Player(2, "Ivan", 130);
        Game game = new Game();

        game.register(Ivan);
        game.register(Petr);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Petr", "Denis")
        );
    }
}
