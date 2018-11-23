package fr.capgemini.utils;


import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {
	public static void sendEmail(String mailFrom, String mailTo, String sujet, String msg) throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		
		email.setSmtpPort(465);
		email.setAuthentication("poe.salesforce@gmail.com","PoeSalesforce");
		email.setSSL(true);
		
		email.setFrom(mailFrom);
		email.addTo(mailTo);
		email.setSubject(sujet);
		email.setMsg(msg);
		
		email.send();
	}
}