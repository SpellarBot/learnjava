package com.rightkarma.util;

import com.rightkarma.learnjava.javapackage.util.PatternDemo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PatternDemoTest {
	
	PatternDemo pd=new PatternDemo();

	@Test
	public void test() {
		String str="This is a sample line. Parse it at your own risk !!";
		List<String> strFound = pd.findPattern(str);
		List<String> expectedOutput=new ArrayList<>();
		expectedOutput.add("is");//from this
		expectedOutput.add("is");
		expectedOutput.add("a");
		expectedOutput.add("a");
		expectedOutput.add("a");
		expectedOutput.add("a");
		expectedOutput.add("is");// from risk
		System.out.println(strFound);
		assertArrayEquals(expectedOutput.toArray(), strFound.toArray());
	}

}
