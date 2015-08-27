package com.validmodel.validate;

import java.lang.annotation.Annotation;

import com.validmodel.Validator;
import com.validmodel.annotation.ValidateAnnotation.Regex;
import com.validmodel.exception.ValidateException;

public class RegexValidate extends Validator {

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		Regex annoRegex = (Regex) anno;
		if (!match(annoRegex.value(), (String) value)){
			throw new ValidateException(annoRegex.message());
		}
	}

}
