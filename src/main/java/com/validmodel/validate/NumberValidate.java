package com.validmodel.validate;

import java.lang.annotation.Annotation;

import com.validmodel.Validator;
import com.validmodel.annotation.ValidateAnnotation.Number.NumberType;
import com.validmodel.exception.ValidateException;

public class NumberValidate extends Validator {
	
	private final String REGEX_POSITIVE 		= "^[1-9]\\d*|0$";
	private final String REGEX_NEGATIVE 		= "^-[1-9]\\d*|0$";
	private final String REGEX_POSITIVE_INT 	= "^[1-9]\\d*$";
	private final String REGEX_NEGATIVE_INT 	= "^-[1-9]\\d*$";

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		com.validmodel.annotation.ValidateAnnotation.Number annoNumber = (com.validmodel.annotation.ValidateAnnotation.Number) anno;
		String val = String.valueOf(value);
		if (annoNumber.value().equals(NumberType.POSITIVE)) {
			if (!match(REGEX_POSITIVE, val))
				throw new ValidateException(String.format(annoNumber.message(), "正数"));
		} else if (annoNumber.value().equals(NumberType.NEGATIVE)) {
			if (!match(REGEX_NEGATIVE, val))
				throw new ValidateException(String.format(annoNumber.message(), "负数"));
		} else if (annoNumber.value().equals(NumberType.POSITIVE_INT)) {
			if (!match(REGEX_POSITIVE_INT, val))
				throw new ValidateException(String.format(annoNumber.message(), "正整数"));
		} else if (annoNumber.value().equals(NumberType.NEGATIVE_INT)) {
			if (!match(REGEX_NEGATIVE_INT, val))
				throw new ValidateException(String.format(annoNumber.message(), "负整数"));
		}
	}

}
