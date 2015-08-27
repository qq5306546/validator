package com.validmodel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public interface ValidateAnnotation {
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Length {
		int min() default 6;
		int max() default 20;
		String message() default "字符串长度必须为%s-%s位";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface NotEmpty {
		String message() default "当前字段不能为空";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Chinese {
		String message() default "请输入中文字符";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Email {
		String message() default "错误的邮箱格式";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface IP4 {
		String message() default "IP4地址错误";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Letter {
		enum LetterType { ALL, LOWER, UPPER }
		String message() default "请输入%s字母";
		LetterType value() default LetterType.ALL;
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Number {
		enum NumberType { 
			POSITIVE,		// 正数
			NEGATIVE,		// 负数
			POSITIVE_INT,   // 正整数
			NEGATIVE_INT 	// 负整数
		}
		String message() default "请输入%s";
		NumberType value();
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface URL {
		String message() default "URL地址错误";
	}
	
	@Target(ElementType.FIELD)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Regex {
		String message();
		String value();
	}
}
