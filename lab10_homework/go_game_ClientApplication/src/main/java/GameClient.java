
import java.io.*;
import java.net.Socket;

public class GameClient {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader userInput;

    public GameClient(String host, int port) {
        try {
            socket = new Socket(host, port);
            System.out.println("Connected to server at " + host + ":" + port);
            out = new PrintWriter(socket.getOutputStream(), true);
            userInput = new BufferedReader(new InputStreamReader(System.in));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                String userInputString = userInput.readLine();
                if (userInputString.equals("exit")) {
                    break;
                } else {
                    out.println(userInputString);
                    String serverResponse = in.readLine();
                    System.out.println(serverResponse);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                userInput.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)  {
        String host = "localhost";
        int port = 5200;
        GameClient gameClient = new GameClient(host,port);
        System.out.println("Starting client...");
        gameClient.start();
    }
}

