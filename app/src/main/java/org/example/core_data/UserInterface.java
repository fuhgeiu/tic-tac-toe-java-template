package org.example.core_data;

import java.util.Scanner;

public class UserInterface {

    private int menuMode;

    public void prompt() {
        System.out.println("    Main Menu \n\n Play Classic (0)\n Options (1)");
    }

    public void getGameMode() {

        Scanner sc = new Scanner(System.in);
        while (true) {

            if (sc.hasNextInt()) {
                menuMode = sc.nextInt();
                if (menuMode == 0 || menuMode == 1) break;
                System.out.println("Must be either 0 or 1");
            } else {
                System.out.println("Invalid input");
                sc.next(); // discard invalid input
            }
        }
        sc.nextLine(); // consume leftover newline

//        System.out.println(gameMode == 0 ? "You selected CLASSIC\n" : "You selected BATTLE\n");


    }



    public int getGameModeValue() {
        return menuMode;
    }
}
