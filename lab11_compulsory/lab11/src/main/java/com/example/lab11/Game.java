package com.example.lab11;

public class Game {
    private int ID;
    private String name;
    private Player  player1;
    private Player  player2;

    public Game(int ID, String name, Player player1, Player player2) {
        this.ID = ID;
        this.name = name;
        this.player1 = player1;
        this.player2 = player2;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
