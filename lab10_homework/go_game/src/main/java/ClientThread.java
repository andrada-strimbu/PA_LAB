import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private PrintWriter out;
    private BufferedReader in;

    public ClientThread(Socket socket) {
        this.socket = socket;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            String inputLine;
            outerloop:
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server received input: " + inputLine); // print the received input
                String[] clientCommandTokens = inputLine.split(" ");
                String command = clientCommandTokens[0];
                switch (command) {
                    case "stop":
                        out.println("Server stopped");


                    default:
                        System.out.println(inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}