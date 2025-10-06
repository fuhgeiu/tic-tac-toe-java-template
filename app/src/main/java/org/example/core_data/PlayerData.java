package org.example.core_data;

public class PlayerData {

    private char symbol;

    public PlayerData(char symbol) {
        this.symbol = symbol;
    }

    public char getPlayerSymbol() {
        return symbol;
    }

    public void displayMenu(BoardData board) {
        System.out.println("Displaying menu for player " + symbol);
    }

    public void validate(BoardData board) {
        System.out.println("Validating move for player " + symbol);
    }
}
