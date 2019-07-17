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
import java.util.Date;
import java.util.ResourceBundle;

public class ChatRoom implements Initializable {

    Date date = new Date();
    String datee = date.toString();

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
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Search.fxml"))));
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

        detailButton.setOnAction(event -> {
            try {
                Client.stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("Detail.fxml"))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        sendButton.setOnAction(event -> {
            new Thread(() -> {
                String msg = sendmessageTextField.getText();
                try {
                    MessageDataBase messageDataBase = new MessageDataBase();
                    messageDataBase.addMessage(Login.username,Search.username,msg,"text",datee,"12:00");
                    Client.dataOutput.writeUTF(msg+"\n");
                    chatpageBox.appendText(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });

        new Thread(() -> {
            try {
                chatpageBox.appendText(Client.dataInput.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
