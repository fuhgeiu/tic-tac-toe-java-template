package org.example.core_data;

import java.util.Scanner;

public class UserInterface {

    private int gameMode;

    public void prompt() {
        System.out.println("Main Menu\nPlay\nClassic (0)\nBattle Mode (1)");
    }

    public void getGameMode() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            if (sc.hasNextInt()) {
                gameMode = sc.nextInt();
                if (gameMode == 0 || gameMode == 1) break;
                System.out.println("Must be either 0 or 1");
            } else {
                System.out.println("Invalid input");
                sc.next(); // discard invalid input
            }
        }
        sc.nextLine(); // consume leftover newline
        System.out.println(gameMode == 0 ? "You selected CLASSIC\n" : "You selected BATTLE\n");
    }

    public int getGameModeValue() {
        return gameMode;
    }
}
