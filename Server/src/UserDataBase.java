import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDataBase {

    private Connection connection;
    private PreparedStatement preparedStatement;


    public UserDataBase() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=mh", "postgres", "gffkke07");
    }

    public void AddUser(User user) throws Exception {
        preparedStatement = connection.prepareStatement("insert into public.messengerdb (firstname, lastname, username, number, password, email, status, photoaddress) values (?,?,?,?,?,?,?,?)");
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getNumber());
        preparedStatement.setString(5, MD5.getMD5Password(user.getPassword()));
        preparedStatement.setString(6, user.getPhotoAddress());
        preparedStatement.setString(7, user.getEmail());
        preparedStatement.setString(8, user.getStatus());
        preparedStatement.executeUpdate();
    }

    public ArrayList<String> getUserUsernames() throws Exception {
        preparedStatement = connection.prepareStatement("select username from public.messengerdb");
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String> usernames = new ArrayList<>();
        while (resultSet.next()) {
            usernames.add(resultSet.getString("username"));
        }
        return usernames;
    }

    public ArrayList<String> getUsers(String username) throws Exception {
        preparedStatement = connection.prepareStatement("select * from public.messengerdb where username = ?");
        preparedStatement.setString(1, username);
        ArrayList<String> details = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            details.add(resultSet.getString("firstName"));
            details.add(resultSet.getString("lastName"));
            details.add(resultSet.getString("username"));
            details.add(resultSet.getString("password"));
            details.add(resultSet.getString("number"));
            details.add(resultSet.getString("photoAddress"));
            details.add(resultSet.getString("email"));
            details.add(resultSet.getString("status"));
        }
        return details;
    }

    public void changeFirstname(String username,String newFirstName) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set firstName = ? where username = ?");
        preparedStatement.setString(1,newFirstName);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changeLastname(String username,String newLastName) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set lastName = ? where username = ?");
        preparedStatement.setString(1,newLastName);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changePassword(String username,String newPassword) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set password = ? where username = ?");
        preparedStatement.setString(1,newPassword);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changeEmail(String username,String newEmail) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set email = ? where username = ?");
        preparedStatement.setString(1,newEmail);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changeStatus(String username,String newStatus) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set status = ? where username = ?");
        preparedStatement.setString(1,newStatus);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changeNumber(String username,String newNumber) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set number = ? where username = ?");
        preparedStatement.setString(1,newNumber);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changePhotoAddress(String username,String newPhotoAddress) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set photoAddress = ? where username = ?");
        preparedStatement.setString(1,newPhotoAddress);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void changeUsername(String username,String newUsername) throws Exception {
        preparedStatement = connection.prepareStatement("update public.messengerdb set username = ? where username = ?");
        preparedStatement.setString(1,newUsername);
        preparedStatement.setString(2,username);
        preparedStatement.executeUpdate();
    }

    public void deleteUser(String username) throws Exception {
        preparedStatement = connection.prepareStatement("delete from public.messengerdb where username = ?");
        preparedStatement.setString(1,username);
        preparedStatement.executeUpdate();
    }

    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
