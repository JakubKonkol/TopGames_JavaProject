package com.example.topgameswebapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping
    public List<String> getLogs() {
        List<String> logs = new ArrayList<>();

        Path path = Paths.get("top-games-logs.log");
        try {
            logs = java.nio.file.Files.lines(path)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            logger.error("Error reading log file", e);
        }
        logs = logs.stream()
                .filter(log -> log.startsWith("INFO") || log.startsWith("WARN") || log.startsWith("ERROR"))
                .collect(Collectors.toList());

        return logs;
    }
}

