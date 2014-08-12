package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test05 {
	public static void main(String[] args) {
	  ApplicationContext 
	  	ctx = new ClassPathXmlApplicationContext("ex02/beans.xml");
	   
	  Car p = (Car)ctx.getBean("car01");
	  System.out.println(p);
	  
	  Car p2 = (Car)ctx.getBean("car02");
	  System.out.println(p2);
	  
	  if(p.getEngine() == p2.getEngine()){
	  	System.out.println("p와 p2의 엔진은 같은 객체입니다.");
	  }
	  
	  Engine e1 = (Engine)ctx.getBean("engine01");
	  if(p.getEngine() == e1){
	  	System.out.println("p의 엔진과 engine01은 같은 객체입니다.");
	  }
  }
}