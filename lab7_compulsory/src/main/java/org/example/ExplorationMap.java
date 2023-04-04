package org.example;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;

    public ExplorationMap(Cell[][] matrix) {
        this.matrix = matrix;
    }


    //Cell should be a wrapper or alias for List<Token>
    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            int n= matrix.length;
            if (matrix[row][col].isVisited()) {
                SharedMemory sharedMemory= new SharedMemory(n);
                List<Token> extractedToken = sharedMemory.extractTokens(2);
                matrix[row][col].setVisited(true);
                System.out.println("Successfully visited cell (" + row + ", " + col + ")");
                return true;
            }
        }
        System.out.println("Visit unsuccessful");
        return false;
    }

    @Override
    public String toString() {
       return null;
    }
}
