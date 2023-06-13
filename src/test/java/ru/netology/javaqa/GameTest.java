package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    @Test
    public void firstPlayerWin() {
        Player tervi = new Player(1, "Andrey", 100);
        Player irty = new Player(2, "Roma", 10);
        Game game = new Game();
        game.reister(tervi);
        game.reister(irty);
        int expected = 1;
        int actual = game.round("Andrey", "Roma");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void secondPlayerWin() {
        Player tervi = new Player(1, "Andrey", 100);
        Player irty = new Player(2, "Roma", 200);
        Game game = new Game();
        game.reister(tervi);
        game.reister(irty);
        int expected = 2;
        int actual = game.round("Andrey", "Roma");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void NoPlayerWin() {
        Player tervi = new Player(1, "Andrey", 100);
        Player irty = new Player(2, "Roma", 100);
        Game game = new Game();
        game.reister(tervi);
        game.reister(irty);
        int expected = 0;
        int actual = game.round("Andrey", "Roma");
        Assertions.assertEquals(expected,actual);
    }
    @Test
    public void firstPlayerNoReg() {
        Player tervi = new Player(1, "Andrey", 100);
        Player irty = new Player(2, "Roma", 10);
        Game game = new Game();
        game.reister(tervi);
        game.reister(irty);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Danya", "Roma"));
    }
    @Test
    public void secondPlayerNoReg() {
        Player tervi = new Player(1, "Andrey", 100);
        Player irty = new Player(2, "Roma", 10);
        Game game = new Game();
        game.reister(tervi);
        game.reister(irty);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Andrey", "Danya"));
    }
    @Test
    public void playersNoReg() {
        Player tervi = new Player(1, "Andrey", 100);
        Player irty = new Player(2, "Roma", 10);
        Game game = new Game();
        game.reister(tervi);
        game.reister(irty);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Danya", "Timur"));
    }
}
