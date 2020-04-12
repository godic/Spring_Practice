package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
		DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);
		
		displayInfo("abstractLookupBean", abstractBean);
		displayInfo("standardLookupBean", standardBean);
		
		ctx.close();
		
	}

	public static void displayInfo(String beanName, DemoBean bean) {
		Singer singer1 = bean.getMySinger();
		Singer singer2 = bean.getMySinger();
		
		System.out.println("" + beanName + ": Singer �ν��Ͻ��� ������? " + (singer1 == singer2));
/*		StopWatch sw = new StopWatch();
		sw.start("lookupDemo");
		for(int x = 0; x < 100000; x++) {
			Singer singer = bean.getMySinger();
			singer.sing();
		}
		
		sw.stop();
	
		System.out.println("100000���� ������ �� �ɸ� �ð�: " + sw.getTotalTimeMillis()+ " ms");
*/	}
}
