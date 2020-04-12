package lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-xml.xml");
		ctx.refresh();
		
		MessageDigester digester = ctx.getBean("digester", MessageDigester.class);
		digester.digest("HelloWorld!");
		
		ctx.close();
	}

}
