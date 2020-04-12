package ioc;

import ioc.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

public class NonSingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		Singer singer1 = ctx.getBean("nonSingleton", Singer.class);
		Singer singer2 = ctx.getBean("nonSingleton", Singer.class);
		
		System.out.println((singer1 == singer2));
		System.out.println(singer1.equals(singer2));
		System.out.println(singer1.toString());
		System.out.println(singer2.toString());
	}

}
