package com.validmodel.validate;

import java.lang.annotation.Annotation;

import com.validmodel.Validator;
import com.validmodel.annotation.ValidateAnnotation.NotEmpty;
import com.validmodel.exception.ValidateException;

public class NotEmptyValidate extends Validator {

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		NotEmpty notEmpty = (NotEmpty) anno;
		String val = (String) value;
		if (val == null || val.trim().equals("")) {
			throw new ValidateException(notEmpty.message());
		}		
	}

}
