package com.validator.validate;

import java.lang.annotation.Annotation;

import com.validator.Validator;
import com.validator.annotation.ValidateAnnotation.Regex;
import com.validator.exception.ValidateException;

public class RegexValidate extends Validator {

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		Regex annoRegex = (Regex) anno;
		if (!match(annoRegex.value(), (String) value)){
			throw new ValidateException(annoRegex.message());
		}
	}

}
