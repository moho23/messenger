
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Start implements Initializable {

    @FXML
    Button startPage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        startPage.setOnAction(event -> {
            try {
                Server.stage.setScene(FXMLLoader.load(getClass().getResource("Menu.fxml")));
            } catch (IOException e) {
                e.getMessage();
            }
        });
    }
}
