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

public class Search implements Initializable {

    public static String username;

    @FXML
    Text usernamenotfoundText;

    @FXML
    Button loginButton;

    @FXML
    Button signupButton;

    @FXML
    Button searchButton;

    @FXML
    TextField enterusernameTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Login.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        signupButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signup.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        searchButton.setOnAction(event -> {
            try {
                boolean checkUsernameNotFound = true;
                username = enterusernameTextField.getText();
                UserDataBase userDataBase = new UserDataBase();
                for (int i = 0; i < userDataBase.getUserUsernames().size(); i++) {
                    if (username.equals(userDataBase.getUserUsernames().get(i))) {
                        checkUsernameNotFound = false;
                        Thread.sleep(850);
                        Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatRoom.fxml"))));
                    }
                }
                if (checkUsernameNotFound) {
                    usernamenotfoundText.setText("Username Not Found!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
