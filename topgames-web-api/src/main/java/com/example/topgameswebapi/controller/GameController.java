package com.example.topgameswebapi.controller;

import com.example.topgamesdata.model.Game;
import com.example.topgameswebapi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/game")
public class GameController {
    GameService gameService;
    Logger log = Logger.getLogger(UserController.class.getName());

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Game>> getAllGames(){
        log.info("Got all games");
        return ResponseEntity.ok(gameService.getAllGames());
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGame(@PathVariable("id") Long id){
        gameService.deleteGame(id);
        log.warning("Game with id " + id + " was deleted");
        return ResponseEntity.ok("ok");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateGame(@RequestBody Game game, @PathVariable("id") Long id){
        gameService.updateGame(id, game);
        log.info("Game with id " + id + " was updated");
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/add")
    public ResponseEntity<Game> createGame(@RequestBody Game game){
        log.info("Game " + game.getName() + " was created");
        return ResponseEntity.ok(gameService.createGame(game));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long id){
        return ResponseEntity.ok(gameService.getGameById(id));
    }
    @PostMapping("/dev/deleteAll")
    public ResponseEntity<String> deleteAllGames(){
        log.info("Deleting all games");
        gameService.deleteAllGames();
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/dev/addSamples")
    public ResponseEntity<String> addSamples(){
        log.info("Adding sample games");
        gameService.addSamples();
        return ResponseEntity.ok("ok");
    }
}
