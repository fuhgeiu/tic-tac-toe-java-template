package org.example.core_data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;

public class LoggerConsole implements Logger {

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
