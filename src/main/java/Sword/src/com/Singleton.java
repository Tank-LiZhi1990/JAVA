package Sword.src.com;

/*
 * 饿汉形式不需要加锁
 * 懒汉需要双重校验锁
 * 
 */
//静态内部类
public class Singleton {

	private Singleton() {
	}

	private static final class Holder {
		private static final Singleton instance = new Singleton();

	}

	public void someMethod() {
		System.out.println("someMethod2");
	}

	public static Singleton getInstacne() {
		return Holder.instance;
	}

	public static void main(String[] args) {
		Singleton2 instance = Singleton2.INSTANCE;
		instance.someMethod();
		instance.someMethod2();

		Singleton instance2 = Singleton.getInstacne();
		instance2.someMethod();
	}
}
