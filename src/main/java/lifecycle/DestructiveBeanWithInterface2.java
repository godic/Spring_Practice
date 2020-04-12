package lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DestructiveBeanWithInterface2 {
	private File file;
	private String filePath;
	
	@PostConstruct
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
