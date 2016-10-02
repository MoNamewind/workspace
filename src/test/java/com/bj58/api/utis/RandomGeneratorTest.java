package com.bj58.api.utis;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class RandomGeneratorTest {

	@Test
	public void testGetRandomString() {
		
		Set<String > randoms=new HashSet<String>(100);
		for (int i = 0; i < 100; i++) {
			String random=RandomGenerator.getRandomString();
			assertFalse(randoms.contains(random));
			randoms.add(random);
		}
		
	}

}
