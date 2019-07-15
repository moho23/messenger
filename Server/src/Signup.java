import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {

    public static String photoAddress;
    public static int bool = 0;

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
    Text photoaddressText;

    @FXML
    TextField emailTextField;

    @FXML
    TextField statusTextField;

    @FXML
    Button choosephotoButton;



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        FileChooser.ExtensionFilter IF = new FileChooser.ExtensionFilter("Image Files", "*.jpj","*.png" );
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(IF);
        choosephotoButton.setOnAction(event -> {
        File file = chooser.showOpenDialog(Server.stage);

            if (file != null) {
                bool = 1;
            }
            photoaddressText.setText(file.toURI().toString());
            photoAddress = file.toURI().toString();
        });


        submitButton.setOnAction(event -> {
            String firstname = nameTextField.getText();
            String lastname = lastnameTextField.getText();
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            String email = emailTextField.getText();
            String status = statusTextField.getText();
            String number = numberTextField.getText();
            User user = new User(firstname,lastname,number,photoAddress,password,username,status,email);
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.AddUser(user);
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
