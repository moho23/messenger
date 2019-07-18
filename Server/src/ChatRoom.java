import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import com.vdurmont.emoji.Emoji;
import com.vdurmont.emoji.EmojiParser;
import org.postgresql.shaded.com.ongres.scram.common.ScramAttributes;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ChatRoom implements Initializable {

    Date date = new Date();
    String datee = date.toString();
    MessageDataBase messageDataBase;
    String daate = datee.split(" ")[3];


    {
        try {
            messageDataBase = new MessageDataBase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

    @FXML
    Text usernameText;

    String Smile = "\uD83D\uDE02";
    String Scry = "\uD83D\uDE2D";
    String Heart = "❤";
    String Fear = "\uD83D\uDE31";
    String Angry = "\uD83D\uDE21";



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usernameText.setText(Search.username);

        smile.setOnAction(event -> {
            chatpageBox.appendText( EmojiParser.parseToUnicode(Smile));
        });

        cry.setOnAction(event -> {
            chatpageBox.appendText( EmojiParser.parseToUnicode(Scry));
        });

        angry.setOnAction(event -> {
            chatpageBox.appendText( EmojiParser.parseToUnicode(Angry));
        });

        fear.setOnAction(event -> {
            chatpageBox.appendText( EmojiParser.parseToUnicode(Fear));
        });

        heart.setOnAction(event -> {
            chatpageBox.appendText( EmojiParser.parseToUnicode(Heart));
        });
        System.out.println();

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
            new Thread(() -> {
                String message = sendmessageTextField.getText();
                try {
                    messageDataBase.addMessage(Login.username,Search.username,message,"text",datee,datee.split(" ")[3]);
                    Server.dataOutput.writeUTF(message);
                    Server.dataOutput.writeUTF(new Date().toString().split(" ")[3]);
                    chatpageBox.appendText(message + "  ");
                    chatpageBox.appendText(new Date().toString().split(" ")[3] + "\n");
                    sendmessageTextField.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        });

        new Thread(() -> {
            try {
                while (true) {
                    chatpageBox.appendText(Server.dataInput.readUTF() + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


}
