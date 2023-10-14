import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void player2NotRegister() {
        Player player1 = new Player(1, "Anna", 60);

        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna", "Vova");
        });
    }

    @Test
    public void player1NotRegister() {
        Player player2 = new Player(2, "Sveta", 60);

        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Anna", "Sveta");
        });
    }

    @Test
    public void player1Winner() {
        Player player1 = new Player(1, "Anna", 260);
        Player player2 = new Player(2, "Sveta", 160);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Anna", "Sveta"));
    }

    @Test
    public void player2Winner() {
        Player player1 = new Player(1, "Anna", 60);
        Player player2 = new Player(2, "Sveta", 160);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(2, game.round("Anna", "Sveta"));
    }

    @Test
    public void equalStrength() {
        Player player1 = new Player(1, "Anna", 60);
        Player player2 = new Player(2, "Sveta", 60);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(0, game.round("Anna", "Sveta"));
    }
}