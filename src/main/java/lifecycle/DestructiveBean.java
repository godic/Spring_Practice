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
			throw new IllegalArgumentException(DestructiveBean.class + "�� filePath�� �����ؾ��մϴ�.");
		}
		
		this.file = new File(filePath);
		this.file.createNewFile();
		
		System.out.println("���� ���翩��: " + file.exists());
	}
	
	public void destroy() {
		System.out.println("bean destroy");
		
		if(!file.delete()) {
			System.out.println("failed deleting file.");
		}
		
		System.out.println("���� ���翩��: " + file.exists());
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
		
		//System.out.println("destroy() ȣ�����");
		//ctx.destroy();
		//System.out.println("destroy() ��");
		System.out.println("program end");
	}

}
