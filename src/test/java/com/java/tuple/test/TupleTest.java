package com.java.tuple.test;

import java.util.Date;

import org.dynamicjavatuples.TupleAB;
import org.dynamicjavatuples.TupleABCDE;
import org.dynamicjavatuples.TupleFactory;
import org.junit.Test;



public class TupleTest {

	@Test
	public void testToupleWithTwoElements() {
		TupleAB<String,Date> birtyDay =  TupleFactory.createInstance(TupleAB.class, "Manish", new Date());
		System.out.println(birtyDay.getA());
		System.out.println(birtyDay.getB());
	}
	
	@Test
	public void testToupleWithFiveElements() {
		TupleABCDE<String,String,String,Integer,String> address =  TupleFactory.createInstance(TupleABCDE.class, "49108 lemarc Street", "apartment 34", "Fremont", 94539, "USA");
		System.out.println(address.getA());
		System.out.println(address.getB());
		System.out.println(address.getC());
		System.out.println(address.getD());
		System.out.println(address.getE());
	}

	@Test
	public void testNestedTouple() {
		TupleAB<String,Date> birtyInfo =  TupleFactory.createInstance(TupleAB.class, "Fremont", new Date());
		TupleAB<String,TupleAB<String,Date>> studentBirthInfo =  TupleFactory.createInstance(TupleAB.class, "Manish Jain",birtyInfo );
		System.out.println( studentBirthInfo.getA());
		System.out.println(studentBirthInfo.getB().getA());
		System.out.println(studentBirthInfo.getB().getB());

	}
	
	
	
}
