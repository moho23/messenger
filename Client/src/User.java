public class User {

    private String name;
    private String lastName;
    private String number;
    private String photoAddress;
    private String password;
    private String userName;
    private String status;
    private String email;

    public User(String name, String lastName, String number, String photoAddress, String password, String userName, String status, String email) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.photoAddress = photoAddress;
        this.password = password;
        this.userName = userName;
        this.status = status;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhotoAddress() {
        return photoAddress;
    }

    public void setPhotoAddress(String photoAddress) {
        this.photoAddress = photoAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
