package lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestFactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-xml.xml");
		ctx.refresh();
		
		MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
		digester.digest("Hello World");
		
		ctx.close();
	}

}
