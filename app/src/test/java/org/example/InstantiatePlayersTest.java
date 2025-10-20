package org.example;

import org.example.core_data.PlayerData;
import org.example.core_data.InstantiatePlayers;
import org.example.core_data.Human;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InstantiatePlayersTest {

    @Test
    void testConstructorNotNull() {
        InstantiatePlayers instantiatePlayers = new InstantiatePlayers(0);
        assertNotNull(instantiatePlayers);
    }

    @Test
    void testInstantiatePlayer1ClassicMode() {
        InstantiatePlayers instantiatePlayers = new InstantiatePlayers(0);
        instantiatePlayers.instantiatePlayer1();
        PlayerData player1 = instantiatePlayers.getPlayer1();

        assertNotNull(player1);
        assertTrue(player1 instanceof Human);
        assertEquals('o', player1.playerSymbolIs());
    }

    @Test
    void testInstantiatePlayer2ClassicMode() {
        InstantiatePlayers instantiatePlayers = new InstantiatePlayers(0);
        instantiatePlayers.instantiatePlayer2();
        PlayerData player2 = instantiatePlayers.getPlayer2();

        assertNotNull(player2);
        assertTrue(player2 instanceof Human);
        assertEquals('x', player2.playerSymbolIs());
    }

    @Test
    void testGetPlayer1BeforeInstantiation() {
        InstantiatePlayers instantiatePlayers = new InstantiatePlayers(0);
        PlayerData player1 = instantiatePlayers.getPlayer1();
        assertNull(player1);
    }

    @Test
    void testGetPlayer2BeforeInstantiation() {
        InstantiatePlayers instantiatePlayers = new InstantiatePlayers(0);
        PlayerData player2 = instantiatePlayers.getPlayer2();
        assertNull(player2);
    }
}
