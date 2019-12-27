package com.github.hiwepy.validation.constraints;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Payload;

import org.apache.oro.text.regex.Perl5Compiler;
/**
 *  正则表达式注解，用于bean的字段或者参数，检查字段是否匹配正则
 */
@Target({ ElementType.FIELD,ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Contains {
	
	/**
	 * @return the regular expression to match
	 */
	String pattern();
	/**
	 * @return the error message template
	 */
	String message() default "{javax.validation.constraints.Pattern.message}";
    
	Class<?>[] groups() default {};
    
	Class<? extends Payload>[] payload() default {};
	
	/**
     * CASE_INSENSITIVE_MASK : 区分大小写 
     * DEFAULT_MASK : 默认(不区分大小写) 
     * EXTENDED_MASK : 支持Perl5 扩展正则表达式 
     * MULTILINE_MASK : 多行匹配，^$匹配每行内容． 
     * SINGLELINE_MASK　：单行匹配  ^$匹配全部内容. 
     * READ_ONLY_MASK : Perl5Pattern 是只读的，提高性能且线程安全． 
     */  
	int mask() default Perl5Compiler.CASE_INSENSITIVE_MASK;
	
}
