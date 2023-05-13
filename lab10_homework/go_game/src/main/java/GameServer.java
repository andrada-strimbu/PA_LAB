import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 5200;
    public GameServer() throws IOException{

        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            while (true){
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer();
    }
}
