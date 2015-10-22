package org.dynamicjavatuples;

import org.dynamicjavatuples.impl.TupleNumber;

public interface Address<A,B,C,D>  extends Tuple{
	@TupleNumber(id=0)
	public A getStreetAddress();
	
	@TupleNumber(id=1)
	public B getCity();
	
	@TupleNumber(id=2)
	public C getZip();
	
	@TupleNumber(id=3)
	public D country();
	
	public static class createInstance extends TupleFactory{
		@SuppressWarnings("unchecked")
		public static <A,B,C,D,E extends Address<A,B,C,D>> E with(A a, B b, C c, D d){
			return (E) getInstance(Address.class, a,b,c,d);
		}
	}


}
