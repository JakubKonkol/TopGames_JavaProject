package com.example.topgameswebapi.service;

import com.example.topgamesdata.model.Game;
import com.example.topgamesdata.repositories.GameRepository;
import com.example.topgamestools.tools.SampleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public Game createGame(Game game){
        return gameRepository.save(game);
    }
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }
    public Game updateGame(Long id, Game gameToUpdate) {
        //todo


        return gameRepository.save(gameToUpdate);

    }
    public Game getGameById(Long id){
        Optional<Game> g = gameRepository.findById(id);
        if (g.isPresent()) {
            return g.get();
        }

        throw new IllegalArgumentException();
    }
    public void deleteGame(Long id){
        gameRepository.deleteById(id);
    }
    public void deleteAllGames(){
        gameRepository.deleteAll();
    }
    public void addSamples(){
        gameRepository.saveAll(SampleData.games);
    }

}
