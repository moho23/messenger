
import javafx.application.Application;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * A simple TCP server. When a client connects, it sends the client the current
 * datetime, then closes the connection. This is arguably the simplest server
 * you can write. Beware though that a client has to be completely served its
 * date before the server will be able to handle another client.
 */
public class Server extends Application {
//    public static JFXPanel stage;
    public static Stage stage;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            launch();
            while (true) {
                String rsp1 = dataInputStream.readUTF();
                System.out.println("Client said: " + rsp1);
                if (rsp1.equals("bye")) break;

                Scanner scanner = new Scanner(System.in);
                String msg2;
                msg2 = scanner.nextLine();
                System.out.println("Server: ");
                dataOutputStream.writeUTF(msg2);

            }
        } catch (IOException e) {
            System.out.println("EXIT");
        }

    }

    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Stage.setScene(new Scene(root,900,900));
        Stage.setTitle("Messenger");
        stage.alwaysOnTopProperty();
        Stage.show();
    }
}