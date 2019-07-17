import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server extends Application {

    static String msgSend;
    static String msgReceive;
    static Stage stage;

    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Stage.setTitle("Messenger");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
    }


    public static ObjectOutputStream out;

    public static void sendMessage(String s) {
        try {
            //String msgSend = new Scanner(System.in).nextLine();
            System.out.println(s);
            out.writeObject(s);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        int port = 9999;
        ChatRoom chatRoom = new ChatRoom();
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket socket = serverSocket.accept();

            out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            if (true) {
                                msgReceive = (String)in.readObject();
                                System.out.println(msgReceive);
                                chatRoom.show(msgReceive);
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            String msgSend = new Scanner(System.in).nextLine();
                            out.writeObject(msgSend);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                }
            }).start();

        } catch (Exception e) {
            System.out.print(e);
        }
        launch(args);
    }
}