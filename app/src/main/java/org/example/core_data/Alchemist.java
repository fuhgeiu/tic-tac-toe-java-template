package org.example.core_data;

import java.util.Scanner;

public class Alchemist implements PlayerData {

    private char playerSymbol;

    public Alchemist() {}

    public Alchemist(char symbol) {
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
        System.out.println("Alchemist ----<>(( ( ");
        if (board.alchemistSpecialAvailable()) {
            System.out.println("normal move (0)");
            System.out.println("special ability available, swap marks (1)");
        }
    }

    @Override
    public void validate(BoardData board) {
        Scanner scanner = new Scanner(System.in);
        int mode = 0;

        if (board.alchemistSpecialAvailable()) {
            System.out.print("Enter a mode: ");
            while (true) {
                if (scanner.hasNextInt()) {
                    mode = scanner.nextInt();
                    break;
                } else {
                    System.out.println("invalid input");
                    scanner.nextLine();
                }
            }
        }

        if (mode == 1) {
            int swap1, swap2;

            System.out.println("Enter 1st mark to swap: ");
            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input");
                    scanner.nextLine();
                    continue;
                }
                swap1 = scanner.nextInt();
                if (!board.rangeValidation(swap1) || board.isEmpty(swap1)) {
                    System.out.println("Invalid or empty spot");
                    continue;
                }
                break;
            }

            System.out.println("Enter 2nd mark to swap: ");
            while (true) {
                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input");
                    scanner.nextLine();
                    continue;
                }
                swap2 = scanner.nextInt();
                if (!board.rangeValidation(swap2) || board.isEmpty(swap2) || board.compareSymbols(playerSymbol, swap2)) {
                    System.out.println("Invalid or duplicate symbol spot");
                    continue;
                }
                break;
            }
            board.swapMarks(swap1, swap2);
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
