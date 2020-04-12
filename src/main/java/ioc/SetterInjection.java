package ioc;

public class SetterInjection {
	private Dependency dependency;
	
	public void setDependency(Dependency dependency) {
		this.dependency = dependency;
	}
	
	public String toString() {
		return dependency.toString();
	}
}
