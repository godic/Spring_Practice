package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

public class DependsOnDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-01.xml");
		ctx.refresh();
		
		Singer johnMayer = ctx.getBean("johnMayer", Singer.class);
		johnMayer.sing();
		
		ctx.close();
	}

}
