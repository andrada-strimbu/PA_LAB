package functionalities;

public class Board {
    private final int SIZE;
    private final int totalBoardElements ;
    private int currentBoardElements = 0;
    private char [][] boardMatrix;
    public void intializeBoard(){
        for (int row = 0; row < SIZE; row ++){
            for (int col = 0; col < SIZE; col ++ ){
                boardMatrix[row][col] = '+';
            }
        }
    }
    public Board(int size){
        this.SIZE = size;
        totalBoardElements = size * size;
        boardMatrix = new char[SIZE][SIZE];
        intializeBoard();
    }

    public void drawBoard() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(boardMatrix[row][col] + "  ");
            }
            System.out.println();
        }
    }
    public void makeMove(int row, int col, char playerSign) {
            boardMatrix[row][col] = playerSign;
            currentBoardElements++;
        }
    public boolean isValidMove(int row, int col){
        if(boardMatrix[row][col] == '+' && currentBoardElements < totalBoardElements ){
            return true;
        }
        return false;
    }
    public boolean isBoardFull(){
        return currentBoardElements == totalBoardElements;
    }

    public boolean hasWon (char playerSymbol){
        boolean winStatement = false;

        winStatement = checkRows(playerSymbol);
        if( winStatement == true) {
            return true;
        }

       winStatement = checkColumns(playerSymbol);
        if(winStatement == true){
            return true;
        }
        winStatement = checkDiagonals(playerSymbol);
        if(winStatement == true){
            return true;
        }
        return winStatement;

    }

    private boolean checkColumns(char playerSign) {
        int counter;
        for(int col = 0; col < SIZE; col ++) {
            counter = 0;
            for (int row = 0; row < SIZE; row++) {
                if (boardMatrix[row][col] == playerSign) {
                    counter++;
                    if( counter == 5){
                        return true;
                    }
                }
                else{
                    counter = 0;
                }

            }
        }
        return false;
    }

    private boolean checkRows(char playerSign) {
        int counter = 0;
        for(int row = 0; row < SIZE; row ++) {
            counter = 0;
            for (int col = 0; col < SIZE; col++) {
                if (boardMatrix[row][col] == playerSign ) {
                    counter++;
                    if( counter == 5){
                        return true;
                    }
                }
                else{
                    counter = 0;
                }
            }
        }
        return false;
    }
    private boolean checkDiagonals(char playerSign) {
        boolean winStatement = false;
        int counter = 0;
        for (int i = 0; i <= SIZE - 5; i++) {
            for (int j = 0; j <= SIZE - 5; j++) {
                counter = 0;
                for (int k = 0; k < 5; k++) {
                    if (boardMatrix[i+k][j+k] == playerSign) {
                        counter++;
                    } else {
                        counter = 0;
                        break;
                    }
                }
                if (counter == 5) {
                    winStatement = true;
                    break;
                }
            }
            if (winStatement) {
                break;
            }
        }
        
        if (!winStatement) {
            for (int i = 0; i <= SIZE - 5; i++) {
                for (int j = SIZE - 1; j >= 4; j--) {
                    counter = 0;
                    for (int k = 0; k < 5; k++) {
                        if (boardMatrix[i+k][j-k] == playerSign ) {
                            counter++;
                        } else {
                            counter = 0;
                            break;
                        }
                    }
                    if (counter == 5) {
                        winStatement = true;
                        break;
                    }
                }
                if (winStatement) {
                    break;
                }
            }
        }

        return winStatement;
    }


}
