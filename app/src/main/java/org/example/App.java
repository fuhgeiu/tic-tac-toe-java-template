package org.example;
import org.example.core_data.InstantiatePlayers;
import org.example.core_data.LoggerConsole;
import org.example.core_data.GameData;
import org.example.core_data.UserInterface;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        boolean keepRunning = true;
        int gamesPlayed = 0;

        LoggerConsole logger = new LoggerConsole();
        logger.loggerStartup();

        Scanner sc = new Scanner(System.in);

        while (keepRunning) {

            gamesPlayed++;

            // Show main menu and get game mode
            UserInterface mainMenu = new UserInterface();
            mainMenu.prompt();
            mainMenu.getGameMode();

            // Instantiate players based on game mode
            InstantiatePlayers players = new InstantiatePlayers(mainMenu.getGameModeValue());
            players.instantiatePlayer1();
            System.out.println();
            players.instantiatePlayer2();

            // Instantiate game: pass in players and board size
            GameData game = new GameData(players.getPlayer1(), players.getPlayer2(), players.getPlayer1(), 9);

            boolean inGame = true;

            while (inGame) {
                System.out.println("\n");
                game.printBoardBoardData();
                System.out.println("\nTurn -> " + game.currentPlayerStatus());

                game.getSetSpot();   // get player move, validate, update
                game.switchPlayer();    // switch turns

                char winner = game.getWin();

                if (winner != '\0') {

                    game.printBoardBoardData();

                    if (winner == '\n') {

                        System.out.println("\nTie has occurred");
                        logger.writeGameWinStatus(0);

                    } else {

                        System.out.println("\nPlayer: " + winner + " WON");
                        if (winner == game.getPlayerOneSymbol()) logger.writeGameWinStatus(1);
                        if (winner == game.getPlayerTwoSymbol()) logger.writeGameWinStatus(2);
                    }

                    System.out.println("\nPlay another game? Yes(1) No(0)");

                    int t;

                    while (true) {

                        if (sc.hasNextInt()) {

                            t = sc.nextInt();
                            if (t == 0 || t == 1) break;
                        } else {
                            sc.next(); // discard invalid
                        }
                        System.out.println("Wrong input, enter 0 or 1");
                    }

                    if (t == 1) {

                        inGame = false; // restart loop

                    } else {
                        keepRunning = false; // exit main loop
                        break;
                    }
                }
            }
        }

        logger.loggerWriteGamesPlayed(gamesPlayed);
        sc.close();
    }
}
