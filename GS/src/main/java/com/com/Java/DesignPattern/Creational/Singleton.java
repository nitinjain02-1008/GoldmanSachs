package com.Java.DesignPattern.Creational;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Singleton implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Singleton instance = null;
	
	private Singleton() {
	//	throw new InstantiationError("Object creation is not allowed");
	}
	
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized (Singleton.class) {
				if(instance==null)
					instance = new Singleton();
			}
		}
		
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		// throw cloneNotSupportedException
		return instance;
	}
	
	
	protected Object readResolve() {
		// throw some kind of exception or return the below instance
		return instance;
	}	
}