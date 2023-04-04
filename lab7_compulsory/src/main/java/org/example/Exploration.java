package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    int n;
    private Cell[][] matrix;
    private final SharedMemory mem = new SharedMemory(n);
    private final ExplorationMap map = new ExplorationMap(matrix);
    private final List<Robot> robots = new ArrayList<>();
//...
    public void start() {
        for (Robot robot : robots) {
            //start a new Thread representing the robot;
        }
    }
    public static void main(String args[]) {
        var explore = new Exploration();
        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        explore.start();
    }

    private void addRobot(Robot robot) {
    }

    public ExplorationMap getMap() {
    return null;
    }
}