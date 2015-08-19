package com.validator.validate;

import java.lang.annotation.Annotation;

import com.validator.Validator;
import com.validator.annotation.ValidateAnnotation.URL;
import com.validator.exception.ValidateException;

public class URLValidate extends Validator {

	private final String REGEX = "^http[s]?:\\/\\/([\\w-]+\\.)+[\\w-]+([\\w-./?%&=]*)?$";
	
	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		URL annoURL = (URL) anno;
		if (!match(REGEX, (String) value)){
			throw new ValidateException(annoURL.message());
		}
	}

}
