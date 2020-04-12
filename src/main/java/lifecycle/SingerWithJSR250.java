package lifecycle;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithJSR250 {
	private static final String DEFAULT_NAME = "Max Shin";
	
	private String name;
	private int age = Integer.MIN_VALUE;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@PostConstruct //java9∫Œ≈Õ ªÁ∂Û¡¸
	private void init() throws Exception{
		System.out.println("init bean");
		
		if(name == null) {
			System.out.println("using default name");
			name = DEFAULT_NAME;
		}
		
		if(age == Integer.MIN_VALUE) {
			throw new IllegalArgumentException(SingerWithJSR250.class + "");
		}
	}
	
	public String toString() {
		return "\tname: " + name + "\n\tage: " + age;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-annotation.xml");
		ctx.refresh();
		
		getBean("singerOne", ctx);
		getBean("singerTwo", ctx);
		getBean("singerThree", ctx);
		
		ctx.close();
	}
	
	private static SingerWithJSR250 getBean(String beanName, ApplicationContext ctx) {
		try {
			SingerWithJSR250 bean = (SingerWithJSR250) ctx.getBean(beanName);
			System.out.println(bean);
			return bean;
		} catch(BeanCreationException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
