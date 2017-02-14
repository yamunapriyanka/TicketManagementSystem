package com.yamuna.util;
import org.apache.commons.mail.EmailException;


public class TestMail {
	
	public static void main(String[] args) {
		
  try {
			MailUtil.sendSimpleMail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

		}
	


