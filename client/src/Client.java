import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getByName("localhost"), 54000);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String result = dis.readUTF();
            if (result.equalsIgnoreCase("stop")) {
                break;
            }
            System.out.println("\nПолученно от сервера: " + result);
            String message = "";
            dos.writeUTF(message);
            System.out.println("\nОтправленно серверу: " + message);
        }

        dis.close();
        dos.close();
        socket.close();
    }
}
