package ioc;

import ioc.ContentHolder;

public class LyricHolder implements ContentHolder{
	private String value = "You be the DJ";
	
	@Override
	public String toString() {
		return "LyricHolder: { " + value + "}"; 
	}
}
