package com.validator.validate;

import java.lang.annotation.Annotation;

import com.validator.Validator;
import com.validator.annotation.ValidateAnnotation.IP4;
import com.validator.exception.ValidateException;

public class IP4Validate extends Validator {
	
	private final String REGEX = "^(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)\\.(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)$";

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		IP4 annoIP4 = (IP4) anno;
		if (!match(REGEX, (String) value)){
			throw new ValidateException(annoIP4.message());
		}
	}

}
