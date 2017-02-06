package com.yamuna.Validator;

import com.yamuna.exception.ValidatorException;
import com.yamuna.model.Role;
import com.yamuna.util.Validator;

public class RoleValidator {

	Validator validator=new Validator();
	public void save(Role role) throws ValidatorException{
		validator.isInvalid(role.getRole(), "NAME");
}
}
