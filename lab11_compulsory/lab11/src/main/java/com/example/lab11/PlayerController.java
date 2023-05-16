package com.example.lab11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
}
