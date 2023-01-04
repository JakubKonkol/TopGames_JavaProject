package com.example.topgamesdata.model;

import com.example.topgamesdata.model.enums.Genre;
import com.example.topgamesdata.model.enums.Platform;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;
//@Entity
//@Table(name = "game")
public class Game {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime releaseDate;
    private List<Genre> genre;
    private List<Platform> platform;
    private Developer developer;

    public Game(Long id,String name, String description, LocalDateTime releaseDate, List<Genre> genre, List<Platform> platform, Developer developer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.platform = platform;
        this.developer = developer;
    }

    public Game() {

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public List<Platform> getPlatform() {
        return platform;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public void setPlatform(List<Platform> platform) {
        this.platform = platform;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}

