package org.example.core_data;

public interface PlayerDataType {

    char playerSymbolIs();
    void setPlayerSymbol(char symbol);

    void displayMenu(BoardData board);
    void validate(BoardData board);
}
