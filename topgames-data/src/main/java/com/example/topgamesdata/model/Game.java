package com.example.topgamesdata.model;

import com.example.topgamesdata.model.enums.Genre;
import com.example.topgamesdata.model.enums.Platform;
import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    private String description;
    private LocalDateTime releaseDate;
    @ElementCollection
    private List<Genre> genre;
    @ElementCollection
    private List<Platform> platform;
    @OneToOne(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private Developer developer;

    public Game(String name, String description, LocalDateTime releaseDate, List<Genre> genre, List<Platform> platform, Developer developer) {
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

