package org.example.core_data;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LoggerConsoleSimple implements Logger {

    private String filename = "logfile.txt";

    @Override
    public void loggerStartup() {

        try {

            String cwd = Paths.get("").toAbsolutePath().toString();
            System.out.println("Current working directory: " + cwd);
            System.out.println("!!Game log is stored in current working directory!!");

            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.err.println("Error creating file: " + e.getMessage());
        }
    }

    @Override
    public void loggerWriteData() {

        // Left empty for compatibility with interface
    }

    public void loggerWriteGamesPlayed(int games) {

        try (FileWriter fileWriter = new FileWriter(filename, true)) {
            fileWriter.write("Number of games played " + games + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }


    private List<String> readLogLines() {

        List<String> lines = new ArrayList<>();

        try (Scanner reader = new Scanner(new File(filename))) {

            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return lines;
    }


    public void loggerShowDataSimple() {

        List<String> lines = readLogLines();
        for (String line : lines) System.out.println(line);
    }

    public void loggerShowDataFormat1() {

        System.out.println("\n\n   Game Results In Current Session \n");

        List<String> lines = readLogLines();
        for (String line : lines) System.out.println(line);

        System.out.println("\n");
    }

    public int LastWonPlayer() {

        List<String> lines = readLogLines();
        if (lines.isEmpty()) return 0;

        String lastLine = lines.get(lines.size() - 1);

        if (lastLine.contains("Player 1 won")) return 1;
        if (lastLine.contains("Player 2 won")) return 2;
        if (lastLine.contains("Player tie")) return 0;

        return -1;
    }


    public void loggerClear() {

        try {
            FileWriter writer = new FileWriter(filename, false);
        }
        catch (Exception e) {
            System.err.println("error operating on file: " + e.getMessage());
        }
    }

    public void writeGameWinStatus(int win, int gamesPlayed) {

        try (FileWriter fileWriter = new FileWriter(filename, true)) {

            if (win == 0) fileWriter.write("game "+ gamesPlayed + " = Player tie\n");
            else if (win == 1) fileWriter.write("game "+ gamesPlayed + " = Player 1 " + "won\n");
            else if (win == 2) fileWriter.write("game "+ gamesPlayed + " = Player 2 " + "won\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
