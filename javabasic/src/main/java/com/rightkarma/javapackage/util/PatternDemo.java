package com.rightkarma.javapackage.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternDemo {

	public List<String> findPattern(String str) {
		List<String> list = new ArrayList<>();
		Pattern p = Pattern.compile("is|a|the");
		Matcher m = p.matcher(str);
		
		while ( m.find()) {
			String strFound = m.group();
			list.add(strFound);
		}
		return list;
	}
}
