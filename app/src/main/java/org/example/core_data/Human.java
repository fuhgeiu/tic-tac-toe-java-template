package org.example.core_data;

import java.util.Scanner;

public class Human implements PlayerData {

    private char playerSymbol;

    public Human() {}
    public Human(char symbol) {
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
        // No menu for human
    }

    @Override
    public void validate(BoardData board) {
        Scanner scanner = new Scanner(System.in);
        int boardSpot;
        while (true) {
            System.out.println("Enter a number " + board.rangeLower() + " - " + board.rangeUpper());
            System.out.print("spot ->");

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
