package org.example.core_data;

import java.util.Scanner;

public class InstantiatePlayers {

    private int gameMode;
    private char player1Symbol = '\0';
    private PlayerData player1;
    private PlayerData player2;

    private final Scanner sc = new Scanner(System.in);

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

    private void displayCharacterOptions() {
        System.out.println(
                "(1) Alchemist -> can swap 2 marks on the board\n" +
                        "(2) Paladin -> can shift existing mark to adjacent spot\n"
        );
    }

    private int getCharacterType() {
        int type;
        while (true) {
            if (sc.hasNextInt()) {
                type = sc.nextInt();
                if (type == 1 || type == 2) break;
            } else {
                sc.next(); // discard invalid input
            }
            System.out.println("Invalid input, enter 1 or 2");
        }
        sc.nextLine();
        return type;
    }

    private char getPlayerSymbol() {
        char symbol;
        while (true) {
            System.out.println("Enter your player symbol (first character will be used):");
            String input = sc.nextLine();
            if (input.isEmpty() || input.charAt(0) == ' ') {
                System.out.println("Cannot be a blank space");
                continue;
            }
            if (input.charAt(0) >= '0' && input.charAt(0) <= '9') {
                System.out.println("Do not enter a number");
                continue;
            }
            if (player1Symbol != '\0' && input.charAt(0) == player1Symbol) {
                System.out.println("Symbol cannot be the same as Player 1");
                continue;
            }

            symbol = input.charAt(0);

            System.out.println("Is this correct symbol: " + symbol + " (0=No, 1=Yes)");
            int verify = sc.nextInt();
            sc.nextLine(); // consume newline
            if (verify == 1) break;
        }
        return symbol;
    }

    public void instantiatePlayer1() {
        if (gameMode == 1) {
            System.out.println("Player 1 choose your character");
            displayCharacterOptions();
            int charType = getCharacterType();
            char symbol = getPlayerSymbol();
            player1Symbol = symbol;

            if (charType == 1) player1 = new Alchemist(symbol);
            else player1 = new Paladin(symbol);

        } else { // Classic mode
            player1 = new Human('O');
        }
    }

    public void instantiatePlayer2() {
        if (gameMode == 1) {
            System.out.println("Player 2 choose your character");
            displayCharacterOptions();
            int charType = getCharacterType();
            char symbol = getPlayerSymbol();

            if (charType == 1) player2 = new Alchemist(symbol);
            else player2 = new Paladin(symbol);

        } else { // Classic mode
            player2 = new Human('X');
        }
    }
}
