package com.zxl.guava;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.primitives.Ints;

public class GuavaTest {
	private static Logger log = LoggerFactory.getLogger(GuavaTest.class);
	
	@Before
	public void before(){
		log.debug("before...........");
	}
	
	@After
	public void after(){
		log.debug("after...........");

	}
	
	@Test(timeout=1001)
	public void testTimeOut(){
		try{
			Thread.sleep(1000);
		}catch(Exception e){
			log.error("", e);
		}
	}
	@Test
	public void testRetainFrom(){
		String string = CharMatcher.DIGIT.retainFrom("some text 89983 and more");
		log.debug(string);
		Assert.assertEquals(string, "89983");
	}
	
	@Test
	public void testJoiner(){
		String[] subdirs = { "usr", "local", "lib" };
		String directory = Joiner.on("/").join(subdirs);
		log.debug(directory);
		int[] numbers = { 1, 2, 3, 4, 5 };
		String numbersAsString = Joiner.on(";").join(Ints.asList(numbers));
		log.debug(numbersAsString);
		List<Integer> numberList = Ints.asList(numbers);
		log.debug(numberList.size()+"");
	}
	
	@Test
	public void testInts(){
		int[] array = { 1, 2, 3, 4, 5 };
		int a = 4;
		Assert.assertTrue(Ints.contains(array, a));

	}
}
