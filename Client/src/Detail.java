import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Detail implements Initializable {

    @FXML
    Button backButton;

    @FXML
    Button settingButton;

    @FXML
    Text usernameText;

    @FXML
    Text lastnameText;

    @FXML
    Text firstnameText;

    @FXML
    Text statusText;

    @FXML
    Text emailText;

    @FXML
    Text numberText;

    @FXML
    Circle photoCircle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatRoom.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        settingButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Setting.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        UserDataBase userDataBase = null;

        try {
            userDataBase = new UserDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }

        usernameText.setText(Login.username);
        try {
            firstnameText.setText(userDataBase.getUsers(Login.username).get(0));
            lastnameText.setText(userDataBase.getUsers(Login.username).get(1));
            numberText.setText(userDataBase.getUsers(Login.username).get(4));
            statusText.setText(userDataBase.getUsers(Login.username).get(7));
            emailText.setText(userDataBase.getUsers(Login.username).get(6));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Signup.bool == 1 || Setting.bool == 1) {
            Image image = new Image(Signup.photoAddress);
            photoCircle.setId(Signup.photoAddress);
            photoCircle.setFill(new ImagePattern(image));
        }
    }
}