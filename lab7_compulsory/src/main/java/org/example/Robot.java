package org.example;

import java.util.ArrayList;
import java.util.List;

public class Robot implements Runnable {
    private final String name;

    private final ExplorationMap map;

    private final SharedMemory sharedMemory;

    private final List<Integer> tokens;

    private int currentX;
    private int currentY;

    private boolean running;

    public Robot(String name, ExplorationMap map, SharedMemory sharedMemory) {
        this.name = name;
        this.map = map;
        this.sharedMemory = sharedMemory;
        this.tokens = new ArrayList<>();
        this.running = true;
        this.currentX = (int) (Math.random() * map.getN());
        this.currentY = (int) (Math.random() * map.getN());
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void run() {
        while (running) {
            int nextX = currentX + (int) (Math.random() * 3) - 1;
            int nextY = currentY + (int) (Math.random() * 3) - 1;

            if (map.isValidPosition(nextX, nextY)) {
                synchronized (map) {
                    if (map.visitCell(nextX, nextY)) {
                        currentX = nextX;
                        currentY = nextY;
                        System.out.println(name + " visited cell (" + currentX + ", " + currentY + ")");
                        addToken();
                    }
                }
            }
        }
    }

    private void addToken() {
        synchronized (sharedMemory) {
            Token token = sharedMemory.takeToken();
            if (token != null && tokens.size() < map.getN()) {
                tokens.add(token.getNumber());
                map.addToken(currentX, currentY, token.getNumber());
            }
        }
    }
}


