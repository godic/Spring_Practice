package ioc;

import org.springframework.stereotype.Component;

@Component("injectSimpleConfig")
public class InjectSimpleConfig {
	
	private String name = "John";
	private int age = 40;
	private float height = 1.92f;
	private boolean programmer = false;
	private Long ageInSeconds = 1_123_124_123L;
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public float getHeight() {
		return height;
	}

	public boolean isProgrammer() {
		return programmer;
	}

	public Long getAgeInSeconds() {
		return ageInSeconds;
	}
}
