package Sword.src.com;

import java.io.Serializable;

// 防止通过ClassLoader以及序列化反序列化的方式建立多个实例
public class Singleton3 implements Serializable {
	/**
	 * 
	 */

	// 成员要声明为瞬时变量
	private transient String attribute;
	private static final long serialVersionUID = 9130138711471502801L;
	private static final Singleton3 INSTANCE = new Singleton3();

	private Singleton3() {

	}

	public static Singleton3 getInstance() {
		return INSTANCE;
	}

	// 防止复原多个单例对象
	public Object readResolve() {
		return INSTANCE;
	}

	// 防止servlet不同的类装载器装载出多个单例对象
	@SuppressWarnings("unused")
	private Class<?> getClass(String clasname) throws ClassNotFoundException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = Singleton3.class.getClassLoader();
		}

		return classLoader.loadClass(clasname);
	}

}
