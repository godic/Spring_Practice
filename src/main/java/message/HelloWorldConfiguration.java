package message;

import message.HelloWorldMessageProvider;
import message.MessageProvider;
import message.MessageRenderer;
import message.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}
	
	@Bean
	public MessageRenderer renderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider());
		return renderer;
	}
}
