package com.validator.validate;

import java.lang.annotation.Annotation;

import com.validator.Validator;
import com.validator.annotation.ValidateAnnotation.Email;
import com.validator.exception.ValidateException;

public class EmailValidate extends Validator {
	
	private final String REGEX = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		Email annoEmail = (Email) anno;
		if (!match(REGEX, (String)value)){
			throw new ValidateException(annoEmail.message());
		}
	}

}
