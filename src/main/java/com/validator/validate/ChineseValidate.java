package com.validator.validate;

import java.lang.annotation.Annotation;

import com.validator.Validator;
import com.validator.annotation.ValidateAnnotation.Chinese;
import com.validator.exception.ValidateException;

public class ChineseValidate extends Validator {

	private final String REGEX = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$";
	
	@Override
	protected void vaildate(Object value, Annotation anno) throws ValidateException {
		Chinese annoChinese = (Chinese) anno;
		if (!match(REGEX, (String) value)){
			throw new ValidateException(annoChinese.message());
		}
	}

}
