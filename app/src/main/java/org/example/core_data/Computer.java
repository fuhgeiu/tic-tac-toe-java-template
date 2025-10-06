package org.example.core_data;

public class Computer implements PlayerDataType {

    private char playerSymbol = 'c';

    public Computer() {}
    public Computer(char symbol) {
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
        System.out.println("Computer is playing");
    }

    @Override
    public void validate(BoardData board) {
        // AI logic would go here
    }
}
