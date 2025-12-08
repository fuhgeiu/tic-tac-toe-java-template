package org.example.core_data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardData {

    private char[] mData;           //store board in a single arry
    private int mLength;
    private int rangeUpper, rangeLower;
    private Adjacent adjacentLists;             // adjacent spots of every spot each in an array
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

    public boolean compareSymbols(char symbol, int spot) {
        return mData[spot] == symbol;
    }

    public boolean isEmpty(int spot) {

        char c = mData[spot - 1];
        return (c >= '1' && c <= '9');
    }

    public boolean isEmpty() {
        for (char c : mData) {
            if (c != ' ') return false;
        }
        return true;
    }

    public int countFilled() {

        int count = 0;
        for (char c : mData) {
            if (c != ' ') count++;
        }

        return count;
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

    public int[] getFreeSpaces () {

        int[] free = new int[mLength];

        for (int  i = 0; i < mLength; i++) {

            if (Character.isDigit(mData[i]) ) free[i] = i;
        }

        return free;
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

    public void undo(int i) {

        mData[i] = mData[i + 1];
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

    public boolean Won() {
        // rows
        if (mData[0] == mData[1] && mData[1] == mData[2]) return true;
        if (mData[3] == mData[4] && mData[4] == mData[5]) return true;
        if (mData[6] == mData[7] && mData[7] == mData[8]) return true;
        // columns
        if (mData[0] == mData[3] && mData[3] == mData[6]) return true;
        if (mData[1] == mData[4] && mData[4] == mData[7]) return true;
        if (mData[2] == mData[5] && mData[5] == mData[8]) return true;
        // diagonals
        if (mData[0] == mData[4] && mData[4] == mData[8]) return true;
        if (mData[2] == mData[4] && mData[4] == mData[6]) return true;
        return false;
    }

}
