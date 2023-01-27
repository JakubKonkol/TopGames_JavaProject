package com.example.topgameswebapi.controller;

import com.example.topgamesdata.model.Developer;
import com.example.topgameswebapi.service.DeveloperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/developer")
public class DeveloperController {
    DeveloperService developerService;
    Logger log = Logger.getLogger(DeveloperController.class.getName());

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Developer>> getAllDevelopers(){
        log.info("Got all developers");
        return ResponseEntity.ok(developerService.getAllDevelopers());
    }
}
