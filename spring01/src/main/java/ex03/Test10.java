package ex03;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test10 {
	public static void main(String[] args) {
	  ApplicationContext 
  	ctx = new ClassPathXmlApplicationContext("ex03/beans.xml");
	  
	  Car car03 = (Car)ctx.getBean("car03");
	  Map<String, Object> options = car03.getOptions();
	  
	  Set<Entry<String, Object>> entrySet = options.entrySet();
	  
	  for(Entry<String, Object> entry : entrySet){
	  	System.out.println(entry.getKey() + "=" + entry.getValue());
	  }
  }
}