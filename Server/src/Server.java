import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Application {
    public static DataInputStream dataInput;
    public static DataOutputStream dataOutput;

    static Stage stage;
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(3512);
        Socket socket=serversocket.accept();
        dataOutput=new DataOutputStream(socket.getOutputStream());
        dataInput=new DataInputStream(socket.getInputStream());
        launch();
    }

    @Override
    public void start(Stage Stage) throws Exception {
        stage=Stage;
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Stage.setScene(new Scene(root,600,400));
        Stage.setTitle("Server");
        stage.alwaysOnTopProperty();
        Stage.show();
    }
}