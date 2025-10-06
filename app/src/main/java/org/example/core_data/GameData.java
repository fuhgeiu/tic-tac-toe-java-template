package org.example.core_data;

public class GameData {

    private char player1C, player2C;
    private PlayerData player1, player2;
    private PlayerData constPlayer1, constPlayer2;
    private PlayerData currentPlayer, constCurrentPlayer;
    private char currentPlayerC;
    private char[] mData;
    private int mLength;
    private BoardData boardDataObj;

    // Constructors
    public GameData() {}

    public GameData(PlayerData player1, PlayerData player2) {

        this.player1 = player1;
        this.player2 = player2;

        if (player1 == null) System.out.println("Error: " + new CException.AccessNullptr("player1 failed to initialize"));
        if (player2 == null) System.out.println("Error: " + new CException.AccessNullptr("player2 failed to initialize"));
    }

    public GameData(PlayerData player1, PlayerData player2, int boardInitializeSize) {

        this.player1 = player1;
        this.player2 = player2;
        this.boardDataObj = new BoardData(boardInitializeSize);

        if (player1 == null) System.out.println("Error: " + new CException.AccessNullptr("player1 failed to initialize"));
        if (player2 == null) System.out.println("Error: " + new CException.AccessNullptr("player2 failed to initialize"));
        if (boardDataObj == null) System.out.println("Error: " + new CException.AccessNullptr("board failed to initialize"));
    }

    public GameData(PlayerData player1, PlayerData player2, PlayerData starter, int boardSize) {

        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = starter;
        this.boardDataObj = new BoardData(boardSize);
    }

    public GameData(char startingPlayer) {

        this.currentPlayerC = startingPlayer;
    }

    public GameData(char startingPlayer, char player1Symbol, char player2Symbol) {

        this.currentPlayerC = startingPlayer;
        this.player1C = player1Symbol;
        this.player2C = player2Symbol;
    }

    // Player switching
    public void switchPlayer() {

        if (currentPlayer == player1) currentPlayer = player2;
        else if (currentPlayer == player2) currentPlayer = player1;
    }

    public char getPlayerOneSymbol() { return player1.playerSymbolIs(); }
    public char getPlayerTwoSymbol() { return player2.playerSymbolIs(); }

    // Player turns
    public void getSetSpot() {

        if (currentPlayer == null) {
            System.out.println("Error: " + new CException.AccessNullptr("current player not assigned"));
            return;
        }
        currentPlayer.displayMenu(boardDataObj);
        currentPlayer.validate(boardDataObj);
    }

    public char currentPlayerStatus() {

        if (currentPlayer == null) {
            System.out.println("current player is null");
            return '\0';
        }
        return currentPlayer.playerSymbolIs();
    }

    public char getWin() {
        return boardDataObj.won();
    }

    public void printBoardBoardData() {
        boardDataObj.printBoard();
    }

    // Primitive version (no player dependency)
    public void switchPlayerC() {
        if (currentPlayerC == player1C) currentPlayerC = player2C;
        else if (currentPlayerC == player2C) currentPlayerC = player1C;
    }

    public char currentPlayerStatusC() { return currentPlayerC; }

    public void createBoardNew(int length) {
        mData = new char[length];
        mLength = length;
        for (int i = 0; i < length; i++) {
            mData[i] = (char) ((i + 1) + '0');
        }
    }

    public void printBoardGameData() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(mData[i * 3 + j]);
                if (j < 2) System.out.print(" | ");
            }
            if (i < 2) System.out.print("\n--+---+--\n");
        }
    }

    public boolean testBoardContainer() {
        boolean isCorrect = true;
        char[] expected = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

        for (int i = 0; i < mLength; i++) {
            if (mData[i] != expected[i]) {
                System.out.println("Error at index " + i + ": expected " + expected[i] + ", got " + mData[i]);
                isCorrect = false;
            }
        }
        return isCorrect;
    }
}
