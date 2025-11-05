package org.example.core_data;

import java.io.FileWriter;
import java.io.File;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

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

    public void loggerShowDataSimple() {

        try {

            File FileObj = new File(filename);
            Scanner Reader = new Scanner(FileObj);

            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }
            Reader.close();

        } catch (IOException e) {
            System.err.println("error reding file: " + e.getMessage());
        }
    }

    public void loggerShowDataFormat1 () {

        try {

            System.out.println("\n\n   Game Results In Current Session \n");

            File FileObj = new File(filename);
            Scanner Reader = new Scanner(FileObj);

            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println(data);
            }

            Reader.close();
            System.out.println(" \n");

        }   catch (IOException e) {
            System.err.println("error reding file: " + e.getMessage());
        }


    }

//    public int LastWonPlayer() {
//
//
//
//        return
//    }

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
            else if (win == 1) fileWriter.write("game "+ gamesPlayed + " = Player one won\n");
            else if (win == 2) fileWriter.write("game "+ gamesPlayed + " = Player two won\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
