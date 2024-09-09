import java.io.*;
import java.net.*;

public class Client {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private BufferedReader stdIn;

    public Client(String serverAddress, int port) throws IOException {
        socket = new Socket(serverAddress, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        stdIn = new BufferedReader(new InputStreamReader(System.in));
    }

    public void play() throws IOException {
        String serverResponse;
        while ((serverResponse = in.readLine()) != null) {
            System.out.println("Servidor: " + serverResponse);

            if (serverResponse.contains("Escolha")) {
                String userMove = stdIn.readLine();
                out.println(userMove);
            }
        }
    }

    public static void main(String[] args) {
        try {
            Client client = new Client("localhost", 1234);
            client.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
