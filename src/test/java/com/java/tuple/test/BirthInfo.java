package com.java.tuple.test;

import java.util.Date;

import org.dynamicjavatuples.Address;
import org.dynamicjavatuples.Tuple;
import org.dynamicjavatuples.TupleFactory;
import org.dynamicjavatuples.impl.TupleNumber;

public interface BirthInfo<A,B,C> extends Tuple {
	@TupleNumber(id=0)
	public String getName();
	
	@TupleNumber(id=1)
	public Date getDate();
	
	@TupleNumber(id=2)
	public Address getBirthPlace();
	
	public static class createInstance extends TupleFactory{
		@SuppressWarnings("unchecked")
		public static <A,B,C,D extends BirthInfo> D with(A a, B b, C c, D d){
			return (D) getInstance(BirthInfo.class, a,b,c,d);
		}
	}



}
