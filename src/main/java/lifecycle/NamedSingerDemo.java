package lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

public class NamedSingerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-xml.xml");
		ctx.refresh();
		
		NamedSinger bean = (NamedSinger) ctx.getBean("maxShin");
		
		bean.sing();
		
		ctx.close();
	}

}
