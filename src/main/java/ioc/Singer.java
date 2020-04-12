package ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Singer implements ApplicationContextAware{
//	private String lyric = "I played a quick game";
	private String singer;
	private Guitar guitar;
	private int age;
	
	ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}
	public Singer() {
		singer = "Max";
	}
	public Singer(String singer) {
		this.singer = singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public void sing() {
		guitar = ctx.getBean("gopher", Guitar.class);
		guitar.sing();
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return singer + " " + age;
	}
}
