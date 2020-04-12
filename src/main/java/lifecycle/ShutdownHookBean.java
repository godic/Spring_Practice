package lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.GenericApplicationContext;

public class ShutdownHookBean {
	private ApplicationContext ctx;
	
	public void setApplicationpContext(ApplicationContext ctx) throws BeansException {
		if(ctx instanceof GenericApplicationContext) {
			((GenericApplicationContext) ctx).registerShutdownHook();
		}
	}
}
