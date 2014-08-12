package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test03 {
	public static void main(String[] args) {
	  ApplicationContext 
	  	ctx = new ClassPathXmlApplicationContext("ex01/beans.xml");
	  
	  // 호출할 생성자를 지정한 car2 객체 얻기	  
	  Car p2 = (Car)ctx.getBean("car02");
	  System.out.print(p2.getModel() + " ");
	  System.out.println(p2.getCc());
	  
	  Car p3 = (Car)ctx.getBean("car03");
	  System.out.print(p3.getModel() + " ");
	  System.out.println(p3.getCc());
	  
	  Car p4 = (Car)ctx.getBean("car04");
	  System.out.print(p4.getModel() + " ");
	  System.out.println(p4.getCc());
  }
}