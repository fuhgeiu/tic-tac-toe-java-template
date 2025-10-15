package org.example;

import org.example.core_data.PlayerData;
import org.example.core_data.GameData;
import org.example.core_data.Human;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameDataTest {

    @Test
    void testConstructorWithPlayers() {
        PlayerData p1 = new Human('x');
        PlayerData p2 = new Human('o');
        GameData gameData = new GameData(p1, p2);
        assertNotNull(gameData);
    }

    @Test
    void testSwitchPlayerC() {
        GameData gameData = new GameData('x', 'x', 'o');
        assertEquals('x', gameData.currentPlayerStatusC());
        gameData.switchPlayerC();
        assertEquals('o', gameData.currentPlayerStatusC());
    }

    @Test
    void testCreateBoardNewAndTestContainer() {
        GameData gameData = new GameData();
        gameData.createBoardNew(9);
        assertTrue(gameData.testBoardContainer());
    }

    @Test
    void testSwitchPlayerObjects() {
        PlayerData p1 = new Human('x');
        PlayerData p2 = new Human('o');
        GameData gameData = new GameData(p1, p2, p1, 9);

        assertEquals('x', gameData.currentPlayerStatus());
        gameData.switchPlayer();
        assertEquals('o', gameData.currentPlayerStatus());
    }

    @Test
    void testCurrentPlayerStatusC() {
        GameData gameData = new GameData('o', 'x', 'o');
        assertEquals('o', gameData.currentPlayerStatusC());
    }
}
