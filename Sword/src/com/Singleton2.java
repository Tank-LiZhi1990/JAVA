package com;

//枚举,理论上的最佳方式
public enum Singleton2 {

	INSTANCE {
		@Override
		protected void someMethod() {
			// TODO Auto-generated method stub
			System.out.println("someMethod");
		}
	};

	protected abstract void someMethod();

	public void someMethod2() {
		System.out.println("method2");
	}
}
