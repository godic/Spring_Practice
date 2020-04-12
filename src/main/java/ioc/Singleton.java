package ioc;

public class Singleton {
	private static Singleton instance;
	
	static {
		instance = new Singleton();
	}
	
	public static Singleton getInstance() {
		return instance;
	}
}
