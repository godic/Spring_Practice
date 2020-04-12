package ioc;

public class ContextualizedDependencyLookup implements ManagedComponent{
	private Dependency dependency;
	
	public void performLookup(Container container) {
		this.dependency = (Dependency) container.getDependency("myDependency");
	}
	
	public String toString() {
		return dependency.toString();
	}
}