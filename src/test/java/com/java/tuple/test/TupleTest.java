package com.java.tuple.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.dynamicjavatuples.Pair;
import org.dynamicjavatuples.TupleFactory;
import org.junit.Test;



public class TupleTest {

	@Test
	public void testToupleWithTwoElements() {
		@SuppressWarnings("unchecked")
		Pair<String,Date> birthDay =  TupleFactory.createInstance(Pair.class, "Manish", new Date());
		System.out.println(birthDay.getA());
		System.out.println(birthDay.getB());
		assertEquals(2,3);
	}
	
}
