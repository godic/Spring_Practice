package lifecycle;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

public class PropertyEditorBean {
	private byte[] bytes;	//ByteArray
	private Character character;
	private Class cls;
	private Boolean trueOrFalse;
	private List<String> stringList; //CustomCollection
	private Date date;
	private Float floatValue; //CustomNumber
	private File file;
	private InputStream stream;
	private Locale locale;
	private Pattern pattern;
	private Properties properties;
	private String trimString;
	private URL url;
	
	
	
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}



	public void setCharacter(Character character) {
		this.character = character;
	}



	public void setCls(Class cls) {
		this.cls = cls;
	}



	public void setTrueOrFalse(Boolean trueOrFalse) {
		this.trueOrFalse = trueOrFalse;
	}



	public void setStringList(List<String> stringList) {
		this.stringList = stringList;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}



	public void setFile(File file) {
		this.file = file;
	}



	public void setStream(InputStream stream) {
		this.stream = stream;
	}



	public void setLocale(Locale locale) {
		this.locale = locale;
	}



	public void setPattern(Pattern pattern) {
		this.pattern = pattern;
	}



	public void setProperties(Properties properties) {
		this.properties = properties;
	}



	public void setTrimString(String trimString) {
		this.trimString = trimString;
	}



	public void setUrl(URL url) {
		this.url = url;
	}

	public static class CustomPropertyEditorRegistrar implements PropertyEditorRegistrar{
		@Override
		public void registerCustomEditors(PropertyEditorRegistry registry) {
			SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
			registry.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
			
			registry.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:lifecycle/app-context-01.xml");
		ctx.refresh();
		
		PropertyEditorBean bean = (PropertyEditorBean) ctx.getBean("builtInSample");
	}

}
