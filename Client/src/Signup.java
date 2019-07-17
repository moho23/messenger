import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Signup implements Initializable {

    public static String photoAddress;
    public static String email;
    public static String username ;
    public static String password;
    public static String number ;
    public static String status;
    public static String firstname ;
    public static String lastname ;
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
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        FileChooser.ExtensionFilter IF = new FileChooser.ExtensionFilter("Image Files", "*.jpj","*.png" );
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(IF);
        choosephotoButton.setOnAction(event -> {
        File file = chooser.showOpenDialog(Client.stage);

            if (file != null) {
                bool = 1;
            }
            photoaddressText.setText(file.toURI().toString());
            photoAddress = file.toURI().toString();
        });

        submitButton.setOnAction(event -> {
             firstname = nameTextField.getText();
            lastname = lastnameTextField.getText();
            username = usernameTextField.getText();
            password = passwordTextField.getText();
            email = emailTextField.getText();
            status = statusTextField.getText();
            number = numberTextField.getText();
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Verify.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
