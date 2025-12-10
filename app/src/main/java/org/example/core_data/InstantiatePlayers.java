package org.example.core_data;

import java.util.Scanner;

public class InstantiatePlayers {

    private int gameMode;
    private char player1Symbol = '\0';
    private PlayerData player1;
    private PlayerData player2;

    private Scanner sc = new Scanner(System.in);

    public InstantiatePlayers(int gameMode) {
        this.gameMode = gameMode;
    }

    public PlayerData getPlayer1() {
        if (player1 == null) System.out.println("Warning: player1 not initialized");
        return player1;
    }

    public PlayerData getPlayer2() {
        if (player2 == null) System.out.println("Warning: player2 not initialized");
        return player2;
    }

    public void instantiatePlayer1() {

            player1 = new Human('o');        // must include to instantiate player
    }

    public void instantiatePlayer2() {

            player2 = new Human('x');            // must include to instantiate player
    }

    public void instantiatePlayer1(boolean computer) {

        player1 = new Computer('o');
    }

    public void instantiatePlayer2(boolean computer) {

        player2 = new Computer('x');
    }
}
