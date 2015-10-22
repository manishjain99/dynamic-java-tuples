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
	@SuppressWarnings("unchecked")
	public static <A,B,C extends Pair<A,B>> C createInstance(Class<C> interfaceName, A a, B b) {
		return (C) getInstance(interfaceName, toObjectArray(a,b));
	}
	@SuppressWarnings("unchecked")
	public static <A,B,C,D,E extends Address<A,B,C,D>> E createInstance(Class<E> interfaceName, A a, B b, C c, D d){
		return (E) getInstance(interfaceName, toObjectArray(a,b,c,d));
	}

	
	protected static Object[] toObjectArray(Object...objects){
		return objects;
	}

	protected static <T extends Tuple> Object getInstance(Class<T> interfaceType, Object...args) {
		
		Tuple t = (Tuple) Proxy.newProxyInstance(
				interfaceType.getClassLoader(), new Class<?>[] { interfaceType },
				new TupleInvocationHandler(new TupleImpl(args)));
		return t;

	}

}
