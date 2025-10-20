package org.example;

import org.example.core_data.Human;
import org.example.core_data.PlayerData;
import org.example.core_data.BoardData;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HumanTest {

    @Test
    void testDefaultConstructor() {
        Human human = new Human();
        assertNotNull(human);
    }

    @Test
    void testConstructorWithSymbol() {
        Human human = new Human('X');
        assertEquals('X', human.playerSymbolIs());
    }

    @Test
    void testSetPlayerSymbol() {
        Human human = new Human();
        human.setPlayerSymbol('O');
        assertEquals('O', human.playerSymbolIs());
    }

    @Test
    void testImplementsPlayerData() {
        Human human = new Human();
        assertTrue(human instanceof PlayerData);
    }

}
