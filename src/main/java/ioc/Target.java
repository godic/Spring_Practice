package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
	private Foo fooOne;
	private Foo fooTwo;
	private Bar bar;
	
	public Target() {
		
	}
	
	public Target(Foo foo) {
		System.out.println("Target(foo)호출");
	}
	
	public Target(Foo foo, Bar bar) {
		System.out.println("Target(foo bar) 호출");
	}
	
	public void setFooOne(Foo fooOne) {
		this.fooOne = fooOne;
		System.out.println("Set fooOne");
	}
	
	public void setFooTwo(Foo fooTwo) {
		this.fooTwo = fooTwo;
		System.out.println("Set fooTwo");
	}
	
	public void setBar(Bar bar) {
		this.bar = bar;
		System.out.println("Set Bar");
	}
	
	public void isSameFoo() {
		System.out.println("fooOne and fooTwo are same?: " + (fooOne==fooTwo));
	}
	
	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-03.xml");
		ctx.refresh();
		
		Target t = null;
		
		System.out.println("byName: ");
		t = ctx.getBean("targetByName", Target.class);
		
		System.out.println("byType: ");
		t = ctx.getBean("targetByType", Target.class);
		t.isSameFoo();
		System.out.println("Constructor: ");
		t = ctx.getBean("targetConstructor", Target.class);
		
		ctx.close();
		
	}
}
