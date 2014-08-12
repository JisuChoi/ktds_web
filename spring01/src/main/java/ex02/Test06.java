package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {
	public static void main(String[] args) {
	  ApplicationContext 
	  	ctx = new ClassPathXmlApplicationContext("ex02/beans.xml");
	   
	  Car p3 = (Car)ctx.getBean("car03");
	  System.out.println(p3);
	  
	  Car p4 = (Car)ctx.getBean("car04");
	  System.out.println(p4);
	  
	  if(p3.getEngine() == p4.getEngine()){
	  	System.out.println("p와 p2의 엔진은 같은 객체입니다.");
	  }
	  
	  Engine e1 = (Engine)ctx.getBean("engine01");
	  if(p3.getEngine() == e1){
	  	System.out.println("p의 엔진과 engine01은 같은 객체입니다.");
	  }
  }
}