package hsvp.digital.allottee_corner.encode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class MD5 {


        public static String encode(byte[] toencode, boolean useshort) {
            try
            {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.reset();
                md5.update(toencode);
                toencode = md5.digest();
                return useshort ? Hex.toString(toencode).substring(8, 24) : Hex.toString(toencode);
            } catch (NoSuchAlgorithmException e)
            {
                e.printStackTrace();
            }
            return "";
        }

}
