import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {

    @FXML
    Button backButton;

    @FXML
    Button LoginButton;

    @FXML
    Button SignupButton;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Start.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        LoginButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        SignupButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signup.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
