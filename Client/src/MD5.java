import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    public static String getMD5Password(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] MD = messageDigest.digest(password.getBytes());
            BigInteger number = new BigInteger(1,MD);
            String txt1 = number.toString(16);
            while (txt1.length()<32) {
                txt1 = "0" + txt1;
            }
            return txt1;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
    }
}
