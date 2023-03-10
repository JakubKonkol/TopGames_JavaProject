package com.example.topgameswebapi.controller;

import com.example.topgamestools.logs.LogFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {

    private final Logger logger = LoggerFactory.getLogger(LogController.class);
    private final LogFilter logFilter = new LogFilter();

    @GetMapping("/all")
    public List<String> getLogs() {
        return logFilter.getLogs();
    }
    @GetMapping("/info")
    public ResponseEntity<List<String>> getInfoLogs() {
        return ResponseEntity.ok(logFilter.getInfoLogs(logFilter.getLogs()));
    }
    @GetMapping("/warning")
    public ResponseEntity<List<String>> getWarningLogs() {
        return ResponseEntity.ok(logFilter.getWarningLogs(logFilter.getLogs()));
    }
    @GetMapping("/error")
    public ResponseEntity<List<String>> getErrorLogs() {
        return ResponseEntity.ok(logFilter.getErrorLogs(logFilter.getLogs()));
    }
    @GetMapping("/debug")
    public ResponseEntity<List<String>> getDebugLogs() {
        return ResponseEntity.ok(logFilter.getDebugLogs(logFilter.getLogs()));
    }


}

