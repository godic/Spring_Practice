package ioc;

public class ConstructorInjection {
	private Dependency dependency;
	
	public ConstructorInjection(Dependency dependency) {
		this.dependency = dependency;
	}
	
	public String toString() {
		return dendency.toString();
	}
}
