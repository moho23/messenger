import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    public static String username;
    private static String password;

    @FXML
    Button backButton;

    @FXML
    Button submitButton;

    @FXML
    TextField usernameField;

    @FXML
    TextField passwordField;

    @FXML
    Text wronginputText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        submitButton.setOnAction(event -> {
            username = usernameField.getText();
            password = MD5.getMD5Password(passwordField.getText());
            try {
                UserDataBase userDataBase = new UserDataBase();
                if (userDataBase.getUsers(username).isEmpty() || !(userDataBase.getUsers(username).get(3).equals(password))) {
                    wronginputText.setText("Wrong Input!");
                } else {
                    Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}