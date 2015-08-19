package com.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.validator.exception.ValidateException;

public abstract class Validator {

	private static final String CLASS_SUFFIX = "Validate";
	
	protected abstract void vaildate(Object value, Annotation anno) throws ValidateException;
	
	public static <T> void vaildate(T model) throws ValidateException {
		String pack = Validator.class.getPackage().getName();
		Field[] fields = model.getClass().getDeclaredFields();
		for (Field field : fields) {
			Annotation[] annons = field.getAnnotations();
			if (annons.length > 0) {
				Object value = getValue(model, field);
				for (Annotation anno : field.getAnnotations()) {
					String clazz = pack + "." + CLASS_SUFFIX.toLowerCase() +  "." + anno.annotationType().getSimpleName() + CLASS_SUFFIX;
					try {
						Validator v = (Validator)Class.forName(clazz).newInstance();
						v.vaildate(value, anno);
					} catch (InstantiationException | IllegalAccessException
							| ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	protected boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	private static <T> Object getValue(T model, Field field){
		try {
			String firstLetter = field.getName().substring(0,1).toUpperCase(); //获得字段第一个字母大写 
			String getMethodName = "get"+firstLetter+field.getName().substring(1); //转换成字段的get方法 
			Method getMethod = model.getClass().getMethod(getMethodName, new Class[] {});
			return getMethod.invoke(model, new Object[] {});
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return null;
	}
}
