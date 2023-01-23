package com.example.topgamestools.sampleData;


import com.example.topgamesdata.model.Developer;
import com.example.topgamesdata.model.Game;
import com.example.topgamesdata.model.User;
import com.example.topgamesdata.model.enums.Genre;
import com.example.topgamesdata.model.enums.Platform;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SampleData {
    public static List<Developer> devs = new ArrayList<>(List.of(
            new Developer("Santa Monica Studio", "America"),
            new Developer("Naughty Dog", "America"),
            new Developer("Rockstar Games", "America"),
            new Developer("CD Projekt Red", "Poland"),
            new Developer("Ubisoft Montreal", "Canada"),
            new Developer("FromSoftware", "Japan")
    ));
    public static List<Game> games = new ArrayList<>(List.of(
            new Game("God of War", "Cool game", LocalDateTime.of(2018, 4, 20, 0, 0), List.of(Genre.ACTION, Genre.ADVENTURE), List.of(Platform.PLAYSTATION), devs.get(0)),
            new Game("The Last of Us", "Cool game", LocalDateTime.of(2013, 6, 14, 0, 0), List.of(Genre.ACTION, Genre.ADVENTURE), List.of(Platform.PLAYSTATION), devs.get(1)),
            new Game("Red Dead Redemption 2", "A game about a cowboy", LocalDateTime.of(2018, 10, 26, 0, 0), List.of(Genre.ACTION, Genre.ADVENTURE), List.of(Platform.PLAYSTATION), devs.get(2)),
            new Game("The Witcher 3: Wild Hunt", "A game about a witcher", LocalDateTime.of(2015, 5, 18, 0, 0), List.of(Genre.ACTION, Genre.ADVENTURE, Genre.RPG, Genre.OPEN_WORLD), List.of(Platform.PLAYSTATION), devs.get(3)),
            new Game("Assassin's Creed Valhalla", "A game about a viking", LocalDateTime.of(2020, 11, 10, 0, 0), List.of(Genre.ACTION, Genre.ADVENTURE), List.of(Platform.PLAYSTATION), devs.get(4)),
            new Game("Dark Souls", "Cool game", LocalDateTime.of(2011, 9, 22, 0, 0), List.of(Genre.ACTION, Genre.ADVENTURE), List.of(Platform.PLAYSTATION), devs.get(5))

    ));
    public static List<User> users = new ArrayList<>(List.of(
            new User("StefanKox2137", "haslo", "plshelpme@java.com", "Stefan", "Stefanowicz" ),
            new User("BigBoy11", "haslo", "bigboy@wp.pl", "Szymon", "Ziutkowski"),
            new User("JavaEnjoyer", "haslo", "javaenjoyer@google.com", "Piot", "Piotrowicz"),
            new User("Strongman1337", "haslo", "essawessie@wp.pl", "Kamil", "Kamilowicz")
    ));
}
