import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * A command line client for the date server. Requires the IP address of
 * the server as the sole argument. Exits after printing the response.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1234);

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//
//            while (true) {
//                Scanner scanner = new Scanner(System.in);
//                System.out.println("Client: ");
//                String msg;
//                msg = scanner.nextLine();
//                dataOutputStream.writeUTF(msg);
//
//                String rsp = dataInputStream.readUTF();
//                System.out.println("Server said: " + rsp);
//                if (rsp.equals("bye")) break;
//            }
        } catch (IOException e) {
            System.out.println("EXIT");
        }
    }
}