/* This file is part of the db4o object database http://www.db4o.com

Copyright (C) 2004 - 2011  Versant Corporation http://www.versant.com

db4o is free software; you can redistribute it and/or modify it under
the terms of version 3 of the GNU General Public License as published
by the Free Software Foundation.

db4o is distributed in the hope that it will be useful, but WITHOUT ANY
WARRANTY; without even the implied warranty of MERCHANTABILITY or
FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
for more details.

You should have received a copy of the GNU General Public License along
with this program.  If not, see http://www.gnu.org/licenses/. */
package com.db4o.reflect.self;

/**
 * Contains the application-specific reflection information (that would
 * be generated by a bytecode enhancer), as opposed to the 'generic'
 * functionality contained in SelfReflector.
 */
public abstract class SelfReflectionRegistry {	

	private final static Class[] ARRAYTYPES={int[].class,long[].class,short[].class,char[].class,byte[].class,boolean[].class,float[].class,double[].class,String[].class};
	private final static Class[] PRIMITIVES={Integer.class,Long.class,Short.class,Character.class,Byte.class,Boolean.class,Float.class,Double.class,String.class};
	
	public boolean isPrimitive(Class clazz) {
		for (int idx = 0; idx < PRIMITIVES.length; idx++) {
			if(PRIMITIVES[idx].equals(clazz)) {
				return true;
			}
		}
		return false;
	}
	
	public abstract ClassInfo infoFor(Class clazz);

	public Object arrayFor(Class clazz,int length) {
		if(Integer.class.isAssignableFrom(clazz)||int.class.isAssignableFrom(clazz)) {
			return new int[length];
		}
		if(Long.class.isAssignableFrom(clazz)||long.class.isAssignableFrom(clazz)) {
			return new long[length];
		}
		if(Short.class.isAssignableFrom(clazz)||short.class.isAssignableFrom(clazz)) {
			return new short[length];
		}
		if(Boolean.class.isAssignableFrom(clazz)||boolean.class.isAssignableFrom(clazz)) {
			return new boolean[length];
		}
		if(Byte.class.isAssignableFrom(clazz)||byte.class.isAssignableFrom(clazz)) {
			return new byte[length];
		}
		if(Character.class.isAssignableFrom(clazz)||char.class.isAssignableFrom(clazz)) {
			return new char[length];
		}
		if(Float.class.isAssignableFrom(clazz)||float.class.isAssignableFrom(clazz)) {
			return new float[length];
		}
		if(Double.class.isAssignableFrom(clazz)||double.class.isAssignableFrom(clazz)) {
			return new double[length];
		}
		if(String.class.isAssignableFrom(clazz)) {
			return new String[length];
		}
		return null;
	}

	public Class componentType(Class clazz) {
		for (int i = 0; i < ARRAYTYPES.length; i++) {
			if(ARRAYTYPES[i].equals(clazz)) {
				return PRIMITIVES[i];
			}
		}
		return null;
	}

	public int arrayLength(Object array) {
		if(array instanceof boolean[]) {
			return ((boolean[])array).length;
		}
		if(array instanceof byte[]) {
			return ((byte[])array).length;
		}
		if(array instanceof short[]) {
			return ((short[])array).length;
		}
		if(array instanceof char[]) {
			return ((char[])array).length;
		}
		if(array instanceof int[]) {
			return ((int[])array).length;
		}
		if(array instanceof long[]) {
			return ((long[])array).length;
		}
		if(array instanceof float[]) {
			return ((float[])array).length;
		}
		if(array instanceof double[]) {
			return ((double[])array).length;
		}
		return 0;
	}

	public void setArray(Object array, int index, Object element) {
		if(array instanceof boolean[]) {
			((boolean[])array)[index]=((Boolean)element).booleanValue();
		}
		if(array instanceof byte[]) {
			((byte[])array)[index]=((Byte)element).byteValue();
		}
		if(array instanceof short[]) {
			((short[])array)[index]=((Short)element).shortValue();
		}
		if(array instanceof char[]) {
			((char[])array)[index]=((Character)element).charValue();
		}
		if(array instanceof int[]) {
			((int[])array)[index]=((Integer)element).intValue();
		}
		if(array instanceof long[]) {
			((long[])array)[index]=((Long)element).longValue();
		}
		if(array instanceof float[]) {
			((float[])array)[index]=((Float)element).floatValue();
		}
		if(array instanceof double[]) {
			((double[])array)[index]=((Double)element).doubleValue();
		}
	}

	public Object getArray(Object array, int index) {
		if(array instanceof boolean[]) {
			return new Boolean(((boolean[])array)[index]);
		}
		if(array instanceof byte[]) {
			return new Byte(((byte[])array)[index]);
		}
		if(array instanceof short[]) {
			return new Short(((short[])array)[index]);
		}
		if(array instanceof char[]) {
			return new Character(((char[])array)[index]);
		}
		if(array instanceof int[]) {
			return new Integer(((int[])array)[index]);
		}
		if(array instanceof long[]) {
			return new Long(((long[])array)[index]);
		}
		if(array instanceof float[]) {
			return new Float(((float[])array)[index]);
		}
		if(array instanceof double[]) {
			return new Double(((double[])array)[index]);
		}
		return null;
	}

	public int flattenArray(Object array, Object[] a_flat) {
		if(array instanceof boolean[]) {
			boolean[] shaped=(boolean[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Boolean(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof byte[]) {
			byte[] shaped=(byte[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Byte(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof short[]) {
			short[] shaped=(short[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Short(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof char[]) {
			char[] shaped=(char[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Character(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof int[]) {
			int[] shaped=(int[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Integer(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof long[]) {
			long[] shaped=(long[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Long(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof float[]) {
			float[] shaped=(float[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Float(shaped[i]);
			}
			return shaped.length;
		}
		if(array instanceof double[]) {
			double[] shaped=(double[])array;
			for (int i = 0; i < shaped.length; i++) {
				a_flat[i]=new Double(shaped[i]);
			}
			return shaped.length;
		}
		return 0;
	}

	public int shapeArray(Object[] a_flat, Object array) {
		if(array instanceof boolean[]) {
			boolean[] shaped=(boolean[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Boolean)a_flat[i]).booleanValue();
			}
			return a_flat.length;
		}
		if(array instanceof byte[]) {
			byte[] shaped=(byte[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Byte)a_flat[i]).byteValue();
			}
			return a_flat.length;
		}
		if(array instanceof short[]) {
			short[] shaped=(short[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Short)a_flat[i]).shortValue();
			}
			return a_flat.length;
		}
		if(array instanceof char[]) {
			char[] shaped=(char[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Character)a_flat[i]).charValue();
			}
			return a_flat.length;
		}
		if(array instanceof int[]) {
			int[] shaped=(int[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Integer)a_flat[i]).intValue();
			}
			return a_flat.length;
		}
		if(array instanceof long[]) {
			long[] shaped=(long[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Long)a_flat[i]).longValue();
			}
			return a_flat.length;
		}
		if(array instanceof float[]) {
			float[] shaped=(float[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Float)a_flat[i]).floatValue();
			}
			return a_flat.length;
		}
		if(array instanceof double[]) {
			double[] shaped=(double[])array;
			for (int i = 0; i < shaped.length; i++) {
				shaped[i]=((Double)a_flat[i]).doubleValue();
			}
			return a_flat.length;
		}
		return 0;
	}
}
