package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class InheritanceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		Singer parent = ctx.getBean("parent", Singer.class);
		Singer child = ctx.getBean("child", Singer.class);
		
		System.out.println(parent);
		System.out.println(child);
	}

}
