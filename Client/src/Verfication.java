import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Verfication implements Initializable {

    @FXML
    Button backButton;

    @FXML
    Button verifyButton;

    @FXML
    PasswordField verificationcodePasswordField;

    @FXML
    Text wronginputText;

    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        backButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Signup.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Email email = new Email();
        email.createCode();
        email.sendMail(Signup.email,"Verification Code", String.valueOf(email.getCode()));
        verifyButton.setOnAction(event -> {
            if (verificationcodePasswordField.getText().equals(email.getCode())) {
                User user = new User(Signup.firstname, Signup.lastname, Signup.number, Signup.photoAddress, Signup.password, Signup.username, Signup.status, Signup.email);
                try {
                    UserDataBase userDataBase = new UserDataBase();
                    userDataBase.AddUser(user);
                    Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                wronginputText.setText("Wrong!");
            }
        });
    }
}
