package com.Java.DesignPattern.Creational;

public enum EnumSingleton {
	
	INSTANCE ;
	
	public void doSomething() {
		
	}
	
	private EnumSingleton() {
		//	throw new InstantiationError("Object creation is not allowed");
		}
		
		public static EnumSingleton getInstance() {
			if(INSTANCE==null) {
				synchronized (Singleton.class) {
					if(INSTANCE==null);
	//					INSTANCE = new EnumSingleton();
				}
			}
			
			return INSTANCE;
		}
}
