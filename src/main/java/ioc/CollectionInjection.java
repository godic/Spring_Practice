package ioc;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {
	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;
	
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();
		
		ctx.close();
	}
	
	public void displayInfo() {
		System.out.println("Map ����: \n");
		map.entrySet().parallelStream().forEach(e->System.out.println("Ű: " + e.getKey() + " - ��: " + e.getValue()));
		
		System.out.println("\nProperty ����:\n");
		props.entrySet().stream().forEach(e->System.out.println("Ű: " + e.getKey() + " - ��: " + e.getValue()));
		
		System.out.println("\nSet ����:\n");
		set.forEach(obj->System.out.println("��: " + obj));
		
		System.out.println("\nList ����:\n");
		list.forEach(obj->System.out.println("��: " + obj));
		
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setList(List list) {
		this.list = list;
	}
	
}

