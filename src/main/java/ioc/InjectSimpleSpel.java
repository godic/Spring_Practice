package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InjectSimpleSpel{
	private String name;
	private int age;
	private float height;
	private boolean programmer;
	private Long ageInSeconds;
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public float getHeight() {
		return height;
	}
	public boolean isProgrammer() {
		return programmer;
	}
	public Long getAgeInSeconds() {
		return ageInSeconds;
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
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		InjectSimpleSpel simple = (InjectSimpleSpel)ctx.getBean("injectSimpleSpel");
		System.out.println(simple);
		
		ctx.close();
	}
}