package com.example.topgamestools.logs;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ClearLogs {
    public void clearLogs() {
        System.out.println("Clearing logs");
        Path path = Paths.get("top-games-logs.log");
        try {
            java.nio.file.Files.write(path, "".getBytes());
        } catch (Exception e) {
            System.out.println("Error clearing log file");
        }
    }
}
