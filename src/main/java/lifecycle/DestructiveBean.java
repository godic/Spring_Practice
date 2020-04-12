package lifecycle;

import java.io.File;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBean {
	private File file;
	private String filePath;
	
	public void afterPropertiesSet() throws Exception{
		System.out.println("init bean");
		
		if(filePath == null) {
			throw new IllegalArgumentException(DestructiveBean.class + "에 filePath를 지정해야합니다.");
		}
		
		this.file = new File(filePath);
		this.file.createNewFile();
		
		System.out.println("파일 존재여부: " + file.exists());
	}
	
	public void destroy() {
		System.out.println("bean destroy");
		
		if(!file.delete()) {
			System.out.println("failed deleting file.");
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
		
		DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");

		ctx.registerShutdownHook();
		
		//System.out.println("destroy() 호출시작");
		//ctx.destroy();
		//System.out.println("destroy() 끝");
		System.out.println("program end");
	}

}
