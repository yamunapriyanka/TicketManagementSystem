package com.yamuna.Validator;

import com.yamuna.exception.ValidatorException;
import com.yamuna.util.Validator;

public class UserInfoValidator {
	
	public static void validatateForRegistration(String name,String emailid,String password) throws ValidatorException{

		Validator.isInvalid(name,"Name");
		Validator.isInvalid(emailid,"emailid");
		Validator.isInvalid(password,"password");
		
		}
	public static void validatateForLogin(String emailid,String password) throws ValidatorException{

		Validator.isInvalid(emailid,"emailid");
		Validator.isInvalid(password,"password");
		
		}
	public static void TicketCreation(String subject, String description, String department, String priority) throws ValidatorException{

		Validator.isInvalid(subject,"subjet");
		Validator.isInvalid(description,"description");
		Validator.isInvalid(department,"department name");
		Validator.isInvalid(priority,"priority");	
		}
	public static void ticketUpdation(Integer id, String description) throws ValidatorException{

		Validator.isInvalid(id,"id");

		Validator.isInvalid(description,"description");
	
		}
	public static void TicketUpdateStatus(Integer id) throws ValidatorException{

		Validator.isInvalid(id,"id");
	
		}


}