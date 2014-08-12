package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {
	public static void main(String[] args) {
	  ApplicationContext 
	  	ctx = new ClassPathXmlApplicationContext("ex01/beans.xml");
	   
	  Car p5 = (Car)ctx.getBean("car05");
	  System.out.print(p5.getModel() + " ");
	  System.out.println(p5.getCc());
	  
	  Car p6 = (Car)ctx.getBean("car06");
	  System.out.print(p6.getModel() + " ");
	  System.out.println(p6.getCc());
  }
}