import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Server extends Application {

    static Stage stage;

    @Override
    public void start(Stage Stage) throws Exception {
        stage = Stage;
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Stage.setTitle("Messenger");
        Stage.setScene(new Scene(root, 600, 400));
        Stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
