import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private Thread thread;
    private Socket clientSocket;
    private DataInputStream dis;
    private DataOutputStream dos;

    Server(Socket clientSocket) throws IOException {
        thread = new Thread(this, "server");
        this.clientSocket = clientSocket;
        dis = new DataInputStream(this.clientSocket.getInputStream());
        dos = new DataOutputStream(this.clientSocket.getOutputStream());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("завершён");
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54000);
        Socket clientSocket;
        while (true) {
            clientSocket = serverSocket.accept();
            new Server(clientSocket);
        }
    }
}
