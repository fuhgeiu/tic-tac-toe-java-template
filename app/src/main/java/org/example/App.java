package org.example;

import org.example.core_data.*;


import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        boolean keepRunning = true;
        int gamesPlayed = 0;

        LoggerConsoleSimple logger = new LoggerConsoleSimple();
        logger.loggerStartup();

        logger.loggerClear();

        Scanner sc = new Scanner(System.in);

        while (keepRunning) {

            gamesPlayed++;

            logger.loggerShowDataFormat1();

            // Show main menu and get game mode   "play against computer" or "play classic"
            UserInterface mainMenu = new UserInterface();
            mainMenu.prompt();
            mainMenu.getGameMode();         // prompt and store game mode value

            InstantiatePlayers players = new InstantiatePlayers(mainMenu.getGameModeValue());



            if (mainMenu.getGameModeValue() == 0) {

                // prompt and set first player to computer or human, 0 is computer and 1 is human
                mainMenu.prompt("who goes first? computer (0) human (1) ");
                mainMenu.setFirstPlayer();

                System.out.println(mainMenu.getFirstPlayer());

                if (mainMenu.getFirstPlayer() == 1) {

                    players.instantiatePlayer1();       // human
                    System.out.println();
                    players.instantiatePlayer2(true);

                }  else {

                    players.instantiatePlayer1(true);       // computer
                    System.out.println();
                    players.instantiatePlayer2();
                }

            } else {

                players.instantiatePlayer1();
                System.out.println();
                players.instantiatePlayer2();
            }

            GameData game = new GameData(players.getPlayer1(),players.getPlayer2(),players.getPlayer1(),9);

//            System.out.println(logger.LastWonPlayer());

            if (mainMenu.getGameModeValue() == 1) {

                if (logger.LastWonPlayer() == 1) {game.switchPlayer();}
            }

            System.out.println("Classic mode");

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
                        logger.writeGameWinStatus(0,gamesPlayed);

                    } else {

                        System.out.println("\nPlayer: " + winner + " WON");
                        if (winner == game.getPlayerOneSymbol()) logger.writeGameWinStatus(1,gamesPlayed);
                        if (winner == game.getPlayerTwoSymbol()) logger.writeGameWinStatus(2,gamesPlayed);
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
