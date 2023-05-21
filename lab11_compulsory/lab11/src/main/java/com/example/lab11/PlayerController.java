package com.example.lab11;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/players")

public class PlayerController {
    private List<Player> players = new ArrayList<>();
    public PlayerController(){
        players.add(new Player(1,"Andrada"));
        players.add(new Player(2,"Ionut"));
    }
    @GetMapping
    public List<Player> getPlayers(){
        return players;
    }
    @PostMapping
    public void addPlayer(@RequestBody Player player) {
        players.add(player);
    }

    @PutMapping("/{id}")
    public void modifyPlayerName(@PathVariable int id, @RequestBody String name) {
        for (Player player : players) {
            if (player.getID() == id) {
                player.setName(name);
                break;
            }
        }
    }
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable int id) {
        Iterator<Player> iterator = players.iterator();
        while (iterator.hasNext()) {
            Player player = iterator.next();
            if (player.getID() == id) {
                iterator.remove();
                break;
            }
        }
    }

}
