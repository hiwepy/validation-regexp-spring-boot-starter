package com.github.vindell.validation.utils;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


/**
 */
public class RegexpPatternUtils {

	protected static Logger LOG = LoggerFactory.getLogger(RegexpPatternUtils.class);
	protected static ConcurrentMap<String, Pattern> COMPLIED_PATTERN = new ConcurrentHashMap<String, Pattern>();
	
	public static Pattern getPattern(String regexp) {
		if (StringUtils.hasText(regexp)) {
			Pattern ret = COMPLIED_PATTERN.get(regexp);
			if (ret != null) {
				return ret;
			}
			ret = Pattern.compile(regexp);
			Pattern existing = COMPLIED_PATTERN.putIfAbsent(regexp, ret);
			if (existing != null) {
				ret = existing;
			}
			return ret;
		}
		return null;
	}
	
	 
	
}
