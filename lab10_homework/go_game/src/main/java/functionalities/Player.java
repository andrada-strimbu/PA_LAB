package functionalities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Player {
    private final String name;
    private final char playerSymbol;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    private int xCoordMove;
    private int yCoordMove;


    public Player (String name, Socket socket, char symbol) throws IOException {
        this.name = name;
        this.playerSymbol = symbol;
        this.socket = socket;
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(),true);
    }
    public String getName() {
        return name;
    }
    public int getxCoordMove() {
        return xCoordMove;
    }

    public int getyCoordMove() {
        return yCoordMove;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setxCoordMove(int xCoordMove) {
        this.xCoordMove = xCoordMove;
    }

    public void setyCoordMove(int yCoordMove) {
        this.yCoordMove = yCoordMove;
    }

    public Socket getSocket() {
        return socket;
    }

    public BufferedReader getIn() {
        return in;
    }

    public PrintWriter getOut() {
        return out;
    }
}
