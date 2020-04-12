package lifecycle;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithInterface implements InitializingBean{
		private static final String DEFAULT_NAME = "Max Shin";
		
		private String name;
		private int age = Integer.MIN_VALUE;
		
		public void setName(String name) {
			this.name = name;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public void afterPropertiesSet() throws Exception{
			System.out.println("init bean");
			
			if(name == null) {
				System.out.println("using default name");
				name = DEFAULT_NAME;
			}
			
			if(age == Integer.MIN_VALUE) {
				throw new IllegalArgumentException(
					SingerWithInterface.class + "");
					
			}
		}
		
		public String toString() {
			return"\tname: " + name + "\n\tage: " + age;
		}
		
		public static void main(String... args) {
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
			ctx.load("classpath:lifecycle/app-context-xml.xml");
			ctx.refresh();
			
			getBean("singerOne", ctx);
			getBean("singerTwo", ctx);
			getBean("singerThree", ctx);
			
			ctx.close();
		}
		
		private static SingerWithInterface getBean(String beanName, ApplicationContext ctx) {
			try {
				SingerWithInterface bean = (SingerWithInterface) ctx.getBean(beanName);
				System.out.println(bean);
				return bean;
			} catch(BeanCreationException ex) {
				System.out.println(ex.getMessage());
				return null;
			}
		}
	

}
