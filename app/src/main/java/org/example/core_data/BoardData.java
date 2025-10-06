package org.example.core_data;

import java.util.Scanner;

public class BoardData {

    private char[] mData;
    private int mLength;
    private int rangeUpper, rangeLower;
    private Adjacent adjacentLists;
    private char[] adjacentSpots;

    public BoardData() {}

    public BoardData(int contSize) {
        this.mLength = contSize;
        createBoardDataContainer(contSize);
        this.rangeUpper = contSize;
        this.rangeLower = 1;
        this.adjacentLists = new Adjacent();
    }

    public void createBoardDataContainer(int length) {
        mData = new char[length];
        for (int i = 0; i < length; i++) {
            mData[i] = (char) ('0' + i + 1);
        }
        mLength = length;
    }

    public void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mData[i * 3 + j]);
                if (j < 2) System.out.print(" | ");
            }
            if (i < 2) System.out.println("\n--+---+--");
        }
    }

    public int rangeUpper() { return rangeUpper; }
    public int rangeLower() { return rangeLower; }

    public boolean rangeValidation(int i) {
        return (i >= rangeLower && i <= rangeUpper);
    }

    public boolean alchemistSpecialAvailable() {
        int turnsTaken = 0;
        for (int i = 0; i < mLength; i++) {
            if (mData[i] != '1' + i) turnsTaken++;
        }
        return turnsTaken > 1;
    }

    public boolean paladinSpecialAvailable() {
        int turnsTaken = 0;
        for (int i = 0; i < mLength; i++) {
            if (mData[i] != '1' + i) turnsTaken++;
        }
        return turnsTaken > 0;
    }

    public boolean compareSymbols(char symbol, int spot) {
        return mData[spot] == symbol;
    }

    public boolean isEmpty(int spot) {
        char c = mData[spot - 1];
        return (c >= '1' && c <= '9');
    }

    public void swapMarks(int spot1, int spot2) {
        char temp = mData[spot1 - 1];
        mData[spot1 - 1] = mData[spot2 - 1];
        mData[spot2 - 1] = temp;
    }

    private void allocateAdjacent(int spot) {
        adjacentSpots = new char[mLength];
        for (int i = 0; i < mLength; i++) adjacentSpots[i] = '\0';

        int[] adj = adjacentLists.refAdjacent(spot);
        for (int i = 0; i < adj.length; i++) {
            int index = adj[i];
            if (index - 1 < mLength && mData[index - 1] >= '1' && mData[index - 1] <= '9') {
                adjacentSpots[i] = mData[index - 1];
            }
        }
    }

    public void showAdjacentSpots(int spot) {
        allocateAdjacent(spot);
        System.out.print("available spots: ");
        for (char c : adjacentSpots) {
            if (c != '\0') System.out.print(c + ",");
        }
        System.out.println();
    }

    public boolean adjacentCheck(int spot) {
        for (char c : adjacentSpots) {
            if (c - '0' == spot) return true;
        }
        return false;
    }

    public void shiftSymbol(int spot1, int spot2) {
        mData[spot2 - 1] = mData[spot1 - 1];
        mData[spot1 - 1] = (char) ('0' + spot1);
    }

    public void setBoardData(int spot, char currentPlayer) {
        if (currentPlayer == '\0') System.out.println("WARNING: current player is null character");
        mData[spot - 1] = currentPlayer;
    }

    public boolean isFull() {
        for (int i = 0; i < 9; i++) {
            if (mData[i] - '0' == i + 1) return false;
        }
        return true;
    }

    public char won() {
        // rows
        if (mData[0] == mData[1] && mData[1] == mData[2]) return mData[0];
        if (mData[3] == mData[4] && mData[4] == mData[5]) return mData[3];
        if (mData[6] == mData[7] && mData[7] == mData[8]) return mData[6];
        // columns
        if (mData[0] == mData[3] && mData[3] == mData[6]) return mData[0];
        if (mData[1] == mData[4] && mData[4] == mData[7]) return mData[1];
        if (mData[2] == mData[5] && mData[5] == mData[8]) return mData[2];
        // diagonals
        if (mData[0] == mData[4] && mData[4] == mData[8]) return mData[0];
        if (mData[2] == mData[4] && mData[4] == mData[6]) return mData[2];
        return isFull() ? '\n' : '\0';
    }

    // test
    public boolean testBoardContainer() {
        char[] expected = {'1','2','3','4','5','6','7','8','9'};
        boolean isCorrect = true;
        for (int i = 0; i < mLength; i++) {
            if (mData[i] != expected[i]) {
                System.out.println("Error at index " + i + ": expected " + expected[i] + ", got " + mData[i]);
                isCorrect = false;
            }
        }
        return isCorrect;
    }
}
