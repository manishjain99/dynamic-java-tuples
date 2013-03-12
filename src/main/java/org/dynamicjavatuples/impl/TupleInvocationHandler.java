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
package org.dynamicjavatuples.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.dynamicjavatuples.Tuple;


public class TupleInvocationHandler implements InvocationHandler{ 
	private static String elementNameList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";  // currnetly only allow 26 elements in touple getA()....getZ();
	private static Method methodToAccessValueOfToupleElement = null;
	static{
		try {
			Class<?> args[] = {int.class};
			methodToAccessValueOfToupleElement = TupleImpl.class.getDeclaredMethod("getElement", args);
		} catch (Throwable e) {
			throw new RuntimeException("could not access method getElement from class" + TupleImpl.class , e);
		}
	}
	private Tuple testImpl;
	
	public TupleInvocationHandler(Tuple impl){
		this.testImpl = impl;
	}
	@Override
	public Object invoke(Object object, Method method, Object[] params)
			throws Throwable {
		Object toRet = null;
		String name = method.getName();
		if(isInvokedMethodIsToAccessToupleElementValue(method, params)){
			String elementName = name.substring("get".length());
			int indexOfElement = elementNameList.indexOf(elementName);
			if(indexOfElement == -1) throw new UnsupportedOperationException("Only support elements with name from A-Z(case-sensative) e.g. getA(), no arguments allowed");
			Object args[] = {indexOfElement};
			toRet = methodToAccessValueOfToupleElement.invoke(testImpl, args);   
		}else{    	   
			toRet = method.invoke(testImpl, params);
		}
		return toRet;
	}
	/*
	 * checks if the method invoke start with name 'get' and method name is only four 
	 * character long, the we assume that method call is to access the value of an
	 * element from touple, whose name is the fourth character in the method call. e.g.
	 * getP(), meaning get the value of the element name P from the touple
	 */
	private boolean isInvokedMethodIsToAccessToupleElementValue(Method method,
			Object[] params) {
		return method.getName().startsWith("get") && 
			   method.getName().length() == "getX".length() && 
			   (params == null || params.length == 0);
	}
}

