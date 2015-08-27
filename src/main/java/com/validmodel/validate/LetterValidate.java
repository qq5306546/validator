package com.validmodel.validate;

import java.lang.annotation.Annotation;

import com.validmodel.Validator;
import com.validmodel.annotation.ValidateAnnotation.Letter;
import com.validmodel.annotation.ValidateAnnotation.Letter.LetterType;
import com.validmodel.exception.ValidateException;
public class LetterValidate extends Validator {

	private final String REGEX_ALL 		= "^[A-Za-z]+$";
	private final String REGEX_LOWER 	= "^[A-Z]+$";
	private final String REGEX_UPPER 	= "^[a-z]+$";

	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		Letter annoLetter = (Letter) anno;
		if (annoLetter.value().equals(LetterType.LOWER)) {
			if (!match(REGEX_LOWER, (String) value))
				throw new ValidateException(String.format(annoLetter.message(), "大写"));
		} else if (annoLetter.value().equals(LetterType.UPPER)) {
			if (!match(REGEX_UPPER, (String) value))
				throw new ValidateException(String.format(annoLetter.message(), "小写"));
		} else {
			if (!match(REGEX_ALL, (String) value))
				throw new ValidateException(String.format(annoLetter.message(), ""));
		}
	}

}
