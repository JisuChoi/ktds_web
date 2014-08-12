package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
	public static void main(String[] args) {
	  ApplicationContext 
	  	ctx = new ClassPathXmlApplicationContext("ex02/beans.xml");
	   
	  Car p5 = (Car)ctx.getBean("car05");
	  System.out.println(p5);
	  
	  Car p6 = (Car)ctx.getBean("car06");
	  System.out.println(p6);
	  
	  Engine engine02 = (Engine)ctx.getBean("engine02");
	  Engine engine03 = (Engine)ctx.getBean("engine02");
	  
	  // hashCode: 객체 식별자, 각각의 인스턴스는 오버라이드 하지 않는 이상 서로 다른 해쉬코드값을 갖는다.
	  System.out.println("p5 = " + p5.getEngine().hashCode());
	  System.out.println("p6 = " + p6.getEngine().hashCode());
	  System.out.println("engine02 = " + engine02.hashCode());
	  System.out.println("engine03 = " + engine03.hashCode());
  }
}