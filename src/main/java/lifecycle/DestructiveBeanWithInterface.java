package lifecycle;

import java.io.File;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithInterface implements InitializingBean, DisposableBean{
	private File file;
	private String filePath;
	
	@Override
	public void afterPropertiesSet() throws Exception{
		System.out.println("init bean");
		
		if(filePath == null) {
			throw new IllegalArgumentException(DestructiveBeanWithInterface.class + "에 filePath를 지정해야합니다.");
		}
		
		this.file = new File(filePath);
		this.file.createNewFile();
		
		System.out.println("파일 존재여부: " + file.exists());
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy bean");
		
		if(!file.delete()) {
			System.out.println("error");
		}
		
		System.out.println("파일 존재여부: " + file.exists());
	}
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-xml.xml");
		ctx.refresh();
		
		DestructiveBeanWithInterface bean = (DestructiveBeanWithInterface) ctx.getBean("destructiveBeanWithInterface");
		
		System.out.println("call destroy()");
		ctx.destroy();
		System.out.println("called destroy()");
	}

}
