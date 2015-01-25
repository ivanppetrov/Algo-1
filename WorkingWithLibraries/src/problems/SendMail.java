package problems;

import java.io.File;

import org.apache.commons.mail.*;

public class SendMail {
	
	public static void main(String[] args) {
		MultiPartEmail  email = new MultiPartEmail ();
		
		try {
			email.setHostName("smtp.mail.yahoo.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("ivan_petrov04", Credentials.PASS));
			email.setSSLOnConnect(true);
			email.setFrom("ivan_petrov04@yahoo.com");
			email.setSubject("Suarez gif");
			email.setMsg("See this gif of Suarez");
			email.addTo("ivan_petrov04@yahoo.com");
			
			email.attach(new File("attachments/Suarez.gif"));
			email.send();
			System.out.println("SENT!");
		} catch (Exception e){
			e.printStackTrace();
		}
		
		
	}

}
