package com.yamuna.Validator;

import com.yamuna.exception.ValidatorException;
import com.yamuna.model.Department;
import com.yamuna.util.Validator;

public class DepartmentValidator {

	Validator validator=new Validator();
	public void save(Department department) throws ValidatorException{
		validator.isInvalid(department.getName(),"DEPARTMENT");
}
}