import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatRoom implements Initializable {

//    Server server = new Server();

    @FXML
    Button backButton;

    @FXML
    Button settingButton;

    @FXML
    Button detailButton;

    @FXML
    Button sendButton;

    @FXML
    TextField sendmessageTextField;

    @FXML
    TextArea chatpageBox;

    @FXML
    MenuItem smile;

    @FXML
    MenuItem cry;

    @FXML
    MenuItem heart;

    @FXML
    MenuItem angry;

    @FXML
    MenuItem fear;

    String Smile = "\uD83D\uDE02";
    String Scry = "\uD83D\uDE2D";
    String Heart = "❤";
    String Fear = "\uD83D\uDE31";
    String Angry = "\uD83D\uDE21";



    @Override
    public void initialize(URL location, ResourceBundle resources) {


        backButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        settingButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Setting.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        detailButton.setOnAction(event -> {
            try {
                Server.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Detail.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sendButton.setOnAction(event -> {
            Server.sendMessage(sendmessageTextField.getText());
        });
    }

    public void show (String s) {
        chatpageBox.setText(s);
    }
}
