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

import java.util.Arrays;

import org.dynamicjavatuples.Tuple;




public final class TupleImpl<A,B> implements Tuple{
	private final Object elements[];
	
	public TupleImpl(Object[] elementsInTouple){
		elements = elementsInTouple.clone();
	}
	public Object getElement(int index){
		return elements[index];
	}
	@Override
	public boolean equals(Object o){
		if(o == null) return false;
		if(o.getClass() != TupleImpl.class) return false;
		return Arrays.deepEquals(elements, ((TupleImpl)o).elements);
	}
	@Override
	public int hashCode(){
		return Arrays.deepHashCode(elements);
	}

}
