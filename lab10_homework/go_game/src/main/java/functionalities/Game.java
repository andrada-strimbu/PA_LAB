package functionalities;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    boolean gameEnd;

    public Game( Player player1, Player player2) {
       board = new Board(10);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.gameEnd = false;
    }
    public void start(){
        while (!gameEnd){
            int x = currentPlayer.getxCoordMove();
            int y = currentPlayer.getyCoordMove();
            if(board.isValidMove(x,y)){
                board.makeMove(x,y,currentPlayer.getPlayerSymbol());

            if (board.hasWon(currentPlayer.getPlayerSymbol())) {
                System.out.println("Congratulations! " + currentPlayer.getName() + " has won the game!");
                gameEnd = true;
            } else if (board.isBoardFull()) {
                System.out.println("The game is a tie.");
                gameEnd = true;
            } else {
                // Switch to the other player's turn
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
        } else {
            System.out.println("Invalid move. Try again.");
        }

        }
    }

}
