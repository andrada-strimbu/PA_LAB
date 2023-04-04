package org.example;
public class Robot implements Runnable {
    private String name;
    private boolean running;
    Exploration explore;
    int col;
    int row;
    public Robot(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Exploration getExplore() {
        return explore;
    }

    public void setExplore(Exploration explore) {
        this.explore = explore;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void run() {
        while (running) {

            explore.getMap().visit(row, col, this);
            //make the robot sleep for some time
        }
    }
}
