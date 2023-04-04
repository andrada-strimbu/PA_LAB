package org.example;
import java.util.List;

public class Cell {
    boolean visited;
    private List<Token> tokens;

    public Cell(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Token> getCell() {
        return tokens;
    }

    public void setCell(List<Token> tokens) {
        this.tokens = tokens;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }


}

