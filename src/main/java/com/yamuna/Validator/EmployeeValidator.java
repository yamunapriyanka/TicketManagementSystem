package com.yamuna.Validator;

import com.yamuna.exception.ValidatorException;
import com.yamuna.model.Employee;
import com.yamuna.util.Validator;

public class EmployeeValidator {

	Validator validator=new Validator();
	public void save(Employee employee) throws ValidatorException{
		validator.isInvalid(employee.getName(), "NAME");
		validator.isInvalid(employee.getEmailId(),"EMAILID");
		validator.isInvalid(employee.getPassword(),"PASSWORD");
}

}