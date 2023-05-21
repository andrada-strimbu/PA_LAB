package com.example.lab11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);

        // Create a RestTemplate instance
        RestTemplate restTemplate = new RestTemplate();

        // Set up the request headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Example usage for PlayerController
        String playerServiceUrl = "http://localhost:8090/players";

        // Get Players
        ResponseEntity<String> playersResponse = restTemplate.exchange(playerServiceUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Players Response: " + playersResponse.getBody());

        // Add Player
        Player newPlayer = new Player(3, "John");
        ResponseEntity<Void> addPlayerResponse = restTemplate.exchange(playerServiceUrl, HttpMethod.POST, new HttpEntity<>(newPlayer, headers), Void.class);
        System.out.println("Add Player Response: " + addPlayerResponse.getStatusCode());

        // Modify Player Name
        String modifyPlayerNameUrl = playerServiceUrl + "/{id}";
        String modifiedName = "Jane";
        ResponseEntity<Void> modifyPlayerResponse = restTemplate.exchange(modifyPlayerNameUrl, HttpMethod.PUT, new HttpEntity<>(modifiedName, headers), Void.class, 3);
        System.out.println("Modify Player Response: " + modifyPlayerResponse.getStatusCode());

        // Delete Player
        String deletePlayerUrl = playerServiceUrl + "/{id}";
        ResponseEntity<Void> deletePlayerResponse = restTemplate.exchange(deletePlayerUrl, HttpMethod.DELETE, new HttpEntity<>(headers), Void.class, 3);
        System.out.println("Delete Player Response: " + deletePlayerResponse.getStatusCode());

        // Example usage for GameController
        String gameServiceUrl = "http://localhost:8090/games";

        // Get Games
        ResponseEntity<String> gamesResponse = restTemplate.exchange(gameServiceUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class);
        System.out.println("Games Response: " + gamesResponse.getBody());

        // Add Game
        Game newGame = new Game(3, "Football", new Player(1, "Andrada"), new Player(2, "Ionut"));
        ResponseEntity<Void> addGameResponse = restTemplate.exchange(gameServiceUrl, HttpMethod.POST, new HttpEntity<>(newGame, headers), Void.class);
        System.out.println("Add Game Response: " + addGameResponse.getStatusCode());

        // Get Game by ID
        String getGameByIdUrl = gameServiceUrl + "/{id}";
        ResponseEntity<String> getGameResponse = restTemplate.exchange(getGameByIdUrl, HttpMethod.GET, new HttpEntity<>(headers), String.class, 3);
        System.out.println("Get Game Response: " + getGameResponse.getBody());

        // Delete Game
        String deleteGameUrl = gameServiceUrl + "/{id}";
        ResponseEntity<Void> deleteGameResponse = restTemplate.exchange(deleteGameUrl, HttpMethod.DELETE, new HttpEntity<>(headers), Void.class, 3);
        System.out.println("Delete Game Response: " + deleteGameResponse.getStatusCode());
    }
}
