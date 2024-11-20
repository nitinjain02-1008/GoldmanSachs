package com.GS;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Singleton instance = null;
	
	private Singleton() {
		throw new InstantiationError("Object creation is not allowed");
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
		// TODO Auto-generated method stub
		return instance;
	}
	
	
	private Object readResolve() {
		return instance;
	}

}
