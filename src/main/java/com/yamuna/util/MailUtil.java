package com.yamuna.util;


	

	import org.apache.commons.mail.DefaultAuthenticator;
	import org.apache.commons.mail.Email;
	import org.apache.commons.mail.EmailException;
	import org.apache.commons.mail.SimpleEmail;
	public class MailUtil {
		
		private  MailUtil() {
		}


	//User mail	
		public static void sendSimpleMail() throws EmailException{
		Email email = new SimpleEmail();

		email.setSmtpPort(587);
		
		email.setAuthenticator(new DefaultAuthenticator("yamunapriyanka424@gmail.com", "chintooo1995"));
		email.setDebug(true);
		email.setHostName("smtp.gmail.com");
		email.setSSLOnConnect(true);
		email.setFrom("yamunapriyanka424@gmail.com");
		email.setSubject("Ticket Management System");
		email.setMsg("hi beauty");
		email.addTo("yamulads.24@gmail.com");
		email.setStartTLSEnabled(true);
		email.send();
		
			
		}
	}

