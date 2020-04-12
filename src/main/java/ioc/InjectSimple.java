package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;

//@Service("injectSimple")
public class InjectSimple{
//	@Value("John")
	private String name;
//	@Value("39")
	private int age;
	//@Value("1.92")
	private float height;
	//@Value("true")
	private boolean programmer;
	//@Value("112314")
	private Long ageInSeconds;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-simple-xml.xml");
		//ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();
		
		InjectSimple simple = (InjectSimple) ctx.getBean("injectSimple");
		System.out.print(simple);
		ctx.close();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}
	
	public String toString() {
		return "이름" + name + "\n"
				+ "나이" + age + "\n"
				+ "나이(초)" + ageInSeconds + "\n"
				+ "프로그래머입니까?: " + programmer;
	}
}