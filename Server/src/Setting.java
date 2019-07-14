import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import javax.jws.soap.SOAPBinding;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Setting implements Initializable {


    @FXML
    Button changefirstnameButton;

    @FXML
    Button changelastnameButton;

    @FXML
    Button logoutButton;

    @FXML
    Button deleteaccountButton;

    @FXML
    Button backButton;

    @FXML
    Button changeemailButton;

    @FXML
    Button changestatusButton;

    @FXML
    Button changeusernameButton;

    @FXML
    Button changepasswordButton;

    @FXML
    Button changenumberButton;

    @FXML
    Button changephotoaddressButton;

    @FXML
    TextField changefirstnameTextField;

    @FXML
    TextField changelastnameTextField;

    @FXML
    TextField changeusernameTextField;

    @FXML
    TextField changepasswordTextField;

    @FXML
    TextField changephotoaddressTextField;

    @FXML
    TextField changeemailTextField;

    @FXML
    TextField changestatusTextField;

    @FXML
    TextField changenumberTextField;

    @FXML
    Text successfullydeletedText;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        deleteaccountButton.setOnAction(event -> {
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.deleteUser(Login.username);
                successfullydeletedText.setText("Successfully Deleted!");
                Thread.sleep(550);
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Start.fxml"))));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        logoutButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Menu.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        backButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Detail.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        changepasswordButton.setOnAction(event -> {
            String changePB = changepasswordTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changePassword(Login.username, changePB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changefirstnameButton.setOnAction(event -> {
            String changeFNB = changefirstnameTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changeFirstname(Login.username, changeFNB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changelastnameButton.setOnAction(event -> {
            String changeLNB = changelastnameTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changeLastname(Login.username, changeLNB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        changenumberButton.setOnAction(event -> {
            String changeNB = changenumberTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changeNumber(Login.username, changeNB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changephotoaddressButton.setOnAction(event -> {
            String changePAB = changephotoaddressTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changePhotoAddress(Login.username, changePAB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changeusernameButton.setOnAction(event -> {
            String changeUNB = changeusernameTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changeUsername(Login.username, changeUNB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changeemailButton.setOnAction(event -> {
            String changeEB = changeemailTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changeEmail(Login.username, changeEB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        changestatusButton.setOnAction(event -> {
            String changeSB = changestatusTextField.getText();
            try {
                UserDataBase userDataBase = new UserDataBase();
                userDataBase.changeStatus(Login.username, changeSB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
