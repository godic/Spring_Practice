package lifecycle;

import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware{
	public String name;
	
	public void setBeanName(String beanName) {
		this.name = beanName;
	}
	
	public void sing() {
		System.out.println("Singer [" + name + "] - sing()");
	}
}
