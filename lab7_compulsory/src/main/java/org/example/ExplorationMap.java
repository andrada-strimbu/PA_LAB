package org.example;


public class ExplorationMap {
    private final int[][] cells;
    private final int n;

    public ExplorationMap(int n) {
        this.n = n;
        cells = new int[n][n];
    }


    public synchronized boolean visitCell(int x, int y) {
        if (cells[x][y] != 0) {
            return false;
        }
        cells[x][y] = 1;
        return true;
    }


    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }



    public synchronized void addToken(int x, int y, int value) {
        cells[x][y] = value;
    }

    public int getN() {
        return n;
    }
}
