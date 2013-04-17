package com.java.tuple.test;

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
		
		Address address = null;
		address = TupleFactory.createInstance(Address.class, a, b)
		
		
		BirthInfo<STring, Date, Address> birthInfo;
		birthInfo = TupleFactory.createInstance(BirthInfo.class, "MAnish", new Date(), address);
	}
	
}
