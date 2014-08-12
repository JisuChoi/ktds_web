package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
	public static void main(String[] args) {
	  ApplicationContext 
  	ctx = new ClassPathXmlApplicationContext("ex03/beans.xml");
	  
	  Car car01 = (Car)ctx.getBean("car01");
	  String[] tires = car01.getTires();
	  
	  for(String tire : tires){
	  	System.out.println(tire);
	  }
  }
}