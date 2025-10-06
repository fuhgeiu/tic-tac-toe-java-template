package org.example.core_data;

import java.util.Scanner;

public class Paladin implements PlayerData {

    private char playerSymbol;

    public Paladin() {}
    public Paladin(char symbol) {
        this.playerSymbol = symbol;
    }

    @Override
    public char playerSymbolIs() {
        return playerSymbol;
    }

    @Override
    public void setPlayerSymbol(char symbol) {
        this.playerSymbol = symbol;
    }

    @Override
    public void displayMenu(BoardData board) {
        System.out.println("Paladin <><<<+-- ");
        if (board.paladinSpecialAvailable()) {
            System.out.println("normal move (0)");
            System.out.println("special move available (1)");
        }
    }

    @Override
    public void validate(BoardData board) {
        Scanner scanner = new Scanner(System.in);
        int mode = 0;

        if (board.paladinSpecialAvailable()) {
            System.out.println("Enter a mode:");
            while (true) {
                if (scanner.hasNextInt()) {
                    mode = scanner.nextInt();
                    if (mode <= 1) break;
                }
                System.out.println("invalid input");
                scanner.nextLine();
            }
        }

        if (mode == 1) {
            int spot1, spot2;
            while (true) {
                System.out.println("Choose a spot to shift:");
                if (!scanner.hasNextInt()) {
                    System.out.println("invalid input");
                    scanner.nextLine();
                    continue;
                }
                spot1 = scanner.nextInt();
                if (board.isEmpty(spot1)) {
                    System.out.println("cannot move an empty spot");
                    continue;
                }
                break;
            }

            while (true) {
                board.showAdjacentSpots(spot1);
                System.out.print("Choose an adjacent spot: ");
                if (!scanner.hasNextInt()) {
                    System.out.println("invalid input");
                    scanner.nextLine();
                    continue;
                }
                spot2 = scanner.nextInt();
                if (!board.adjacentCheck(spot2)) {
                    System.out.println("must be adjacent");
                    continue;
                }
                break;
            }
            board.shiftSymbol(spot1, spot2);
        }

        if (mode == 0) {
            int boardSpot;
            while (true) {
                System.out.println("Enter a number " + board.rangeLower() + " - " + board.rangeUpper());
                if (!scanner.hasNextInt()) {
                    System.out.println("invalid input");
                    scanner.nextLine();
                    continue;
                }
                boardSpot = scanner.nextInt();
                if (!board.rangeValidation(boardSpot)) {
                    System.out.println("out of range");
                    continue;
                }
                if (!board.isEmpty(boardSpot)) {
                    System.out.println("spot is taken");
                    continue;
                }
                break;
            }
            board.setBoardData(boardSpot, playerSymbol);
        }
    }
}
