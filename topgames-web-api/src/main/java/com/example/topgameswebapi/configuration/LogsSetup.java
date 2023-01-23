package com.example.topgameswebapi.configuration;

import com.example.topgamestools.logs.ClearLogs;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class LogsSetup {
    @PostConstruct
    public void setup() {
        ClearLogs cl = new ClearLogs();
        cl.clearLogs();
    }
}
