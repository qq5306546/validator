package com.validmodel.validate;

import java.lang.annotation.Annotation;

import com.validmodel.Validator;
import com.validmodel.annotation.ValidateAnnotation.Email;
import com.validmodel.exception.ValidateException;

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
