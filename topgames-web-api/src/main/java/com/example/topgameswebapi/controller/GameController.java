package com.example.topgameswebapi.controller;

import com.example.topgamesdata.model.Game;
import com.example.topgameswebapi.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {
    GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Game>> getAllGames(){
//        gameService.createGame(new Game());
        return ResponseEntity.ok(gameService.getAllGames());
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteGame(@RequestParam(name = "id") Long id){
        gameService.deleteGame(id);
        return ResponseEntity.ok("ok");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateGame(@RequestBody Game game, @PathVariable("id") Long id){
        gameService.updateGame(id, game);
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/add")
    public ResponseEntity<Game> createGame(@RequestBody Game game){
        return ResponseEntity.ok(gameService.createGame(game));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable("id") Long id){
        return ResponseEntity.ok(gameService.getGameById(id));
    }
    @GetMapping("/deleteAll")
    public ResponseEntity<String> deleteAllGames(){
        gameService.deleteAllGames();
        return ResponseEntity.ok("ok");
    }
}
