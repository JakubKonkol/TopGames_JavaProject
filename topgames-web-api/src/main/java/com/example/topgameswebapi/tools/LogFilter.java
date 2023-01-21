package com.example.topgameswebapi.tools;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter implements IFilterLogs{
    public List<String> getLogs(){
        List<String> logs = new ArrayList<>();
        Path path = Paths.get("top-games-logs.log");
        try {
            logs = java.nio.file.Files.lines(path)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("Error reading log file");
        }
        return logs;
    }
    @Override
    public List<String> getInfoLogs(List<String> logs) {
        return logs.stream()
                .filter(log -> log.startsWith("INFO"))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getWarningLogs(List<String> logs) {
        return logs.stream()
                .filter(log -> log.startsWith("WARN"))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getErrorLogs(List<String> logs) {
        return logs.stream()
                .filter(log -> log.startsWith("ERROR"))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getDebugLogs(List<String> logs) {
        return logs.stream()
                .filter(log -> log.startsWith("DEBUG"))
                .collect(Collectors.toList());
    }
}
