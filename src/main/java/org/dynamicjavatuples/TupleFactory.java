 /*   
  * Copyright (C) 2013 Manish Jain <manishjain99@gmail.com> 
  * This file is part of DynamicJavaTuples.
  * 
  * DynamicJavaTuples is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.
  * 
  * DynamicJavaTuples is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.
  * 
  * You should have received a copy of the GNU General Public License
  * along with DynamicJavaTuples.  If not, see 
  * <http://www.gnu.org/licenses/>.
  */
package org.dynamicjavatuples;

import java.lang.reflect.Proxy;

import org.dynamicjavatuples.impl.TupleImpl;
import org.dynamicjavatuples.impl.TupleInvocationHandler;


public class TupleFactory {
	public static <A,B> TupleAB<A,B> createInstance(Class<TupleAB> toupleType, A a, B b) {
		return (TupleAB<A,B>) getInstance(toupleType, toObjectArra(a,b));
	}
	public static <A,B,C> TupleABC<A,B,C> createInstance(Class<TupleABC> toupleType, A a, B b, C c) {
		return (TupleABC<A,B,C>) getInstance(toupleType, toObjectArra(a,b,c));
	}
	public static <A,B,C,D> TupleABCD<A,B,C,D> createInstance(Class<TupleABCD> toupleType, A a, B b, C c, D d) {
		return (TupleABCD<A,B,C,D>) getInstance(toupleType, toObjectArra(a,b,c,d));
	}
	public static <A, B, C, D, E> TupleABCDE<A, B, C, D, E> createInstance(Class<TupleABCDE> toupleType, A a, B b, C c, D d, E e) {
		return (TupleABCDE<A, B, C, D, E>) getInstance(toupleType, toObjectArra(a,b,c,d,e));
	}

	
	private static Object[] toObjectArra(Object...objects){
		return objects;
	}

	private static <A extends Tuple> Object getInstance(Class<A> interfaceType, Object arr[]) {
		@SuppressWarnings("rawtypes")
		int noOfElementsInTouple = interfaceType.getTypeParameters().length;
		if(noOfElementsInTouple > 26) throw new UnsupportedOperationException("Cannot create touple with more than 26 elements");
		Tuple t = (Tuple) Proxy.newProxyInstance(
				interfaceType.getClassLoader(), new Class<?>[] { interfaceType },
				new TupleInvocationHandler(new TupleImpl(arr)));
		return t;

	}

}
