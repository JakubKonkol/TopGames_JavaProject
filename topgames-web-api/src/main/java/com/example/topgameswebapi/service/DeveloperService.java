package com.example.topgameswebapi.service;

import com.example.topgamesdata.model.Developer;
import com.example.topgamesdata.repositories.DeveloperRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }
}
