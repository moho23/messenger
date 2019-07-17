import java.sql.*;
import java.util.ArrayList;

public class MessageDataBase {
    private Connection connection;
    private PreparedStatement preparedStatement;


    public MessageDataBase() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=mh", "postgres", "gffkke07");
    }

    public void addMessage (String sender, String message, String receiver, String type,String date, String time) throws Exception {
        preparedStatement = connection.prepareStatement("insert into public.messagedb  values (?,?,?,?,?,?)");
        preparedStatement.setString(1, sender);
        preparedStatement.setString(3, receiver);
        preparedStatement.setString(2, message);
        preparedStatement.setString(4, type);
        preparedStatement.setString(5, date);
        preparedStatement.setString(6, time);
        preparedStatement.executeUpdate();
    }

    public ArrayList<String> getMessage(String sender, String reciever) throws SQLException {
        preparedStatement = connection.prepareStatement("select message from public.messagedb where sender = ? AND receiver = ?   ");
        preparedStatement.setString(1, sender);
        preparedStatement.setString(2, reciever);
        ArrayList<String> msgs = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            msgs.add(resultSet.getString("text"));
        }
        return msgs;
    }
}
