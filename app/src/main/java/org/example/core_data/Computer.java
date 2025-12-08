package org.example.core_data;

import java.util.Random;

public class Computer implements PlayerData {

    private char playerSymbol = 'c';
    private Random random = new Random();

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

        int move;

        if (board.isEmpty()) {

            int[] corners = {0, 2, 6, 8};
            move = corners[random.nextInt(corners.length)];

            if (board.isEmpty(move)) {

                board.setBoardData(move, playerSymbol);
                return;
            }
        }

        if (board.countFilled() == 1 && board.isEmpty(4)) {

            board.setBoardData(4,playerSymbol);
            return;
        }

        move = findWinningMove(board, playerSymbol);

        if (move != -1) {
            board.setBoardData(move,playerSymbol);
            return;
        }

        char opponent = (playerSymbol == 'X') ? 'O' : 'X';
        move = findWinningMove(board, opponent);
        if (move != -1) {
            board.setBoardData(move,playerSymbol);
            return;
        }

        int[] free = board.getFreeSpaces();

        move = free[random.nextInt(free.length)];
        board.setBoardData(move,playerSymbol);
    }

    private int findWinningMove(BoardData board, char s) {

        for (int i = 0; i < 9; i++) {

            if (board.isEmpty(i)) {

                board.setBoardData(i, s);
                boolean win = board.Won();
                board.undo(i);
                if (win) return i;
            }
        }

        return -1;
    }

}

