package com.validator.validate;

import java.lang.annotation.Annotation;

import com.validator.Validator;
import com.validator.annotation.ValidateAnnotation.Length;
import com.validator.exception.ValidateException;

public class LengthValidate extends Validator {

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		Length annoLength = (Length) anno;
		String val = (String) value;
		int min = annoLength.min();
		int max = annoLength.max();
		if (val.length() < min || val.length() > max) {
			throw new ValidateException(String.format(annoLength.message(), min, max));
		}
	}
	

}
