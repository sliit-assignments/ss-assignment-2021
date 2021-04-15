<%@ page import = "java.io.*" %>
<%@ page import = "java.security.MessageDigest" %>
<%@ page import = "java.security.NoSuchAlgorithmException" %>
<%@ page import = "java.security.SecureRandom" %>
<%@ page import = "java.util.Base64" %>
<%@ page import = "java.*" %>

<%@ include file="index.jsp" %>  
<hr/>  
  
<h3>Login Form</h3>  
<%  

out.print("Hello");  
PkceUtil pk = new PkceUtil();
String CodeVerifier = pk.generateCodeVerifier();
session.setAttribute ( "CodeVerifier", CodeVerifier);

String CodeChallenge = pk.generateCodeChallange(CodeVerifier);
session.setAttribute ( "CodeChallenge", CodeChallenge);  

out.write(CodeVerifier);  
out.write(CodeChallenge);  
 %>  
 <br/>  
<form action="loginprocess.jsp" method="post">  
Email:<input type="text" name="email"/><br/><br/>  
Password:<input type="password" name="password"/><br/><br/>  
<input type="submit" value="login"/>"  
</form>