package com.rightkarma.learnjava.javapackage.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// LearningNote - use of Pattern and Matcher class
public class PatternDemo {


    public static void main(String[] args) {
        String patterString = "is|a|the";
        Pattern p = Pattern.compile("is|a|the");

        String inputString = "This is a sample line. Parse it at your own risk !!";
        Matcher m = p.matcher(inputString);
        while (m.find()) {
            String strFound = m.group();
            System.out.println(String.format("strFound: %s %n",strFound));
        }
    }
}
