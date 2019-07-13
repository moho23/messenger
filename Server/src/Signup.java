import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {

    @FXML
    Button backButton;

    @FXML
    Button submitButton;

    @FXML
    TextField nameTextField;

    @FXML
    TextField lastnameTextField;

    @FXML
    TextField usernameTextField;

    @FXML
    TextField passwordTextField;

    @FXML
    TextField numberTextField;

    @FXML
    TextField photoaddressTextField;

    @FXML
    TextField emailTextField;

    @FXML
    TextField statusTextField;


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
            String firstname = nameTextField.getText();
            String lastname = lastnameTextField.getText();
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            String email = emailTextField.getText();
            String status = statusTextField.getText();
            String number = numberTextField.getText();
            String photoaddress = photoaddressTextField.getText();
            User user = new User(firstname,lastname,number,photoaddress,password,username,status,email);
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.AddUser(user);
//                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("ChatRoom.fxml"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
