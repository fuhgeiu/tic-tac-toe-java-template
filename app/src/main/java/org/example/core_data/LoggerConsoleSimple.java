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

            System.out.println("\n\n   Game Data In Current Session \n");

            File FileObj = new File(filename);
            Scanner Reader = new Scanner(FileObj);

            int gameCount = 0;

            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                System.out.println("game " + (++gameCount) + " result = " + data);
            }

            Reader.close();
            System.out.println(" \n");

        }   catch (IOException e) {
            System.err.println("error reding file: " + e.getMessage());
        }




    }

    public void writeGameWinStatus(int win) {

        try (FileWriter fileWriter = new FileWriter(filename, true)) {

            if (win == 0) fileWriter.write("Player tie\n");
            else if (win == 1) fileWriter.write("Player one won\n");
            else if (win == 2) fileWriter.write("Player two won\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
