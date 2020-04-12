package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;
public class MethodReplaceMentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget");
		ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");
		
		displayInfo(replacementTarget);
		displayInfo(standardTarget);
		
		ctx.close();
	}
	
	private static void displayInfo(ReplacementTarget target) {
		System.out.println(target.formatMessage("Thanks for playing, try again!"));
		
		StopWatch sw = new StopWatch();
		sw.start("perfTest");
		
		for(int i = 0; i< 10000; i++) {
			String out = target.formatMessage("No filter in my head");
			
			//System.out.println(out);
		}
		
		sw.stop();
		System.out.println("" + sw.getTotalTimeMillis() + " ms");
	}

}
