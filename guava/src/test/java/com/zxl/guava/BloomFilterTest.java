package com.zxl.guava;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {
	private static Logger log = LoggerFactory.getLogger(GuavaTest.class);

	private static BloomFilter<Integer> IntbloomFilter = BloomFilter.create(Funnels.integerFunnel(), 1000000);

	private static BloomFilter<CharSequence> StrbloomFilter = BloomFilter.create(Funnels.stringFunnel(), 10000);
	
	@BeforeClass
	public static void before(){
		log.debug("before....");
	}
	@AfterClass
	public static void after(){
		log.debug("after");
	}
	@Test
	public void testIntBloomFilter(){
		for(int i=0;i<1000000;i++){
			IntbloomFilter.put(Integer.valueOf(i));
		}
		boolean mayBeContained = IntbloomFilter.mightContain(Integer.valueOf(129));
		log.debug(mayBeContained+"");
		mayBeContained = IntbloomFilter.mightContain(Integer.valueOf(156));
		log.debug(mayBeContained+"");
		mayBeContained = IntbloomFilter.mightContain(Integer.valueOf(166666667));
		log.debug(mayBeContained+"");
	}
	@Test
	public void testStrBloomFilter(){
		for(int i=0;i<1000000;i++){
			StrbloomFilter.put(i+"0kl");
		}
		boolean mayBeContained = StrbloomFilter.mightContain("10990kl");
		log.debug(mayBeContained+"");
		mayBeContained = StrbloomFilter.mightContain("yyy");
		log.debug(mayBeContained+"");
		mayBeContained = StrbloomFilter.mightContain("109904kl");
		log.debug(mayBeContained+"");
	}
}
