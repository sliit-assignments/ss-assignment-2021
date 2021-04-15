import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class LoginBean {  
private String email,pass;  
  
public String getEmail() {  
//    return "Shanika";  
    
   
    
}  
  
public void setEmail(String email) {  
    this.email = email;  
}  
  
public String getPass() {  
    return "123";  
}  
  
public void setPass(String pass) {  
    this.pass = pass;  
}  
  
String generateCodeVerifier() throws UnsupportedEncodingException {
    SecureRandom secureRandom = new SecureRandom();
    byte[] codeVerifier = new byte[32];
    secureRandom.nextBytes(codeVerifier);
    System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier));
    return Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier);
}
String generateCodeChallange(String codeVerifier) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    byte[] bytes = codeVerifier.getBytes("US-ASCII");
    MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
    messageDigest.update(bytes, 0, bytes.length);
    byte[] digest = messageDigest.digest();
    System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(digest));
    return Base64.getUrlEncoder().withoutPadding().encodeToString(digest);
}
  
}  