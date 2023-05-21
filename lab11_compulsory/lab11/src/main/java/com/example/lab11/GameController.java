package com.example.lab11;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {
    private List<Game> games = new ArrayList<>();
      Player player1= new Player(1,"Andrada");
       Player player2= new Player(2,"Ionut");
    public GameController() {
        // Initialize some example games
        games.add(new Game(1, "Chess",player1,player2));
        games.add(new Game(2, "Monopoly",player1,player2));
    }

    @GetMapping
    public List<Game> getGames() {
        return games;
    }

    @PostMapping
    public void addGame(@RequestBody Game game) {
        games.add(game);
    }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable int id) {
        for (Game game : games) {
            if (game.getID() == id) {
                return game;
            }
        }
        return null; 
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable int id) {
        games.removeIf(game -> game.getID() == id);
    }
}
