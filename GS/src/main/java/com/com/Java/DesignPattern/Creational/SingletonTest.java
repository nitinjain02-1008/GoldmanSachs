package com.Java.DesignPattern.Creational;

import java.lang.reflect.Constructor;

public class SingletonTest {

	public static void main(String[] args) {
		
		Singleton s1 = Singleton.getInstance();
		
		Singleton s2 = null;
		
		try {
			Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
			
			for(Constructor<?> cnstrcr : constructors) {
				cnstrcr.setAccessible(true);
				s2 = (Singleton) cnstrcr.newInstance();
				break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
	}

}
