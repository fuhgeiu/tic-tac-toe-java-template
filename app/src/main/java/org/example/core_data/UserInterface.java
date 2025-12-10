package org.example.core_data;

import java.util.Scanner;

public class UserInterface {

    private int menuMode;
    private int firstPlayer;

    public void prompt() {

        System.out.println(" Play Against Computer (0) \n\n Play Classic (1)\n");
    }

    public void prompt(String prompt) {

        System.out.print(prompt);
    }

    public int getFirstPlayer() {return firstPlayer;}

    public void getGameMode() {

        Scanner sc = new Scanner(System.in);
        while (true) {

            if (sc.hasNextInt()) {
                menuMode = sc.nextInt();
                if (menuMode == 1 || menuMode == 0) break;
                System.out.println("Must be either 0 or 1");
            } else {
                System.out.println("Invalid input");
                sc.next(); // discard invalid input
            }
        }
        sc.nextLine(); // consume leftover newline
    }

    public void setFirstPlayer () {

        Scanner sc = new Scanner(System.in);

        while (true) {

            if (sc.hasNextInt()) {

                firstPlayer = sc.nextInt();
                if (firstPlayer == 1 || firstPlayer == 0) break;
                System.out.println("Must be either 0 or 1");
            } else {
                System.out.println("Invalid input");
                sc.next(); // discard invalid input
            }
        }
        sc.nextLine(); // consume leftover newline
    }

    public int getGameModeValue() {

        return menuMode;
    }
}
