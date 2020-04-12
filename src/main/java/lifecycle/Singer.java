package lifecycle;

import org.springframework.beans.BeanInfoFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Singer {
	private static final String DEFAULT_NAME = "Max Shin";
	
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	private void init() {
		System.out.println("init bean");
		
		if(name == null) {
			System.out.println("use default name");
			name = DEFAULT_NAME;
		}
		
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(
				Singer.class + "빈 타입에는 반드시 age 프로퍼티를 설정해야합니다.");
		}		
	}

	public String toString() {
		return "\tname: " + name +"\n\tage: " + age;
	}
	
	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-xml.xml");
		ctx.refresh();
		
		getBean("singerOne", ctx);
		getBean("singerTwo", ctx);
		getBean("singerThree", ctx);
		
		ctx.close();
	}
	
	public static Singer getBean(String beanName, ApplicationContext ctx) {
		try {
			Singer bean = (Singer) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch(BeanCreationException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}
 }
	
	
