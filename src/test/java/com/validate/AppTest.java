package com.validate;

import java.math.BigDecimal;

import com.validator.Validator;
import com.validator.exception.ValidateException;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    
	public void test(){
		
		TestModel model = new TestModel();
		model.setId(123);
		model.setName("http://www.baidu.com");
		model.setMoney(new BigDecimal(1));
		try {
			Validator.vaildate(model);
		} catch (ValidateException e) {
			e.printStackTrace();
		}
	}
}
