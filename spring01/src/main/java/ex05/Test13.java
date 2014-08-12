package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test13 {
	public static void main(String[] args) {
	  ApplicationContext 
  	ctx = new ClassPathXmlApplicationContext("ex05/beans.xml");

	  Car car1 = (Car)ctx.getBean("car01");
	  System.out.println(car1.hashCode());
	  
	  Car car2 = (Car)ctx.getBean("car02");
	  System.out.println(car2.hashCode());
	  
	  Car car3 = (Car)ctx.getBean("car03");
	  System.out.println(car3.hashCode());
	  Car car3_1 = (Car)ctx.getBean("car3-1");
	  System.out.println(car3_1.hashCode());
	  Car car3_2 = (Car)ctx.getBean("car3-2");
	  System.out.println(car3_2.hashCode());
	  Car car3_3 = (Car)ctx.getBean("car3-3");
	  System.out.println(car3_3.hashCode());
	  
	  Car car4 = (Car)ctx.getBean("car04");
	  System.out.println(car4.hashCode());
	  Car car4_1 = (Car)ctx.getBean("car4-1");
	  System.out.println(car4_1.hashCode());
	  Car car4_2 = (Car)ctx.getBean("car4-2");
	  System.out.println(car4_2.hashCode());
	  
	  System.out.println("car3 별명들: ------------------------------------");
	  // 별명 출력, 이 객체에 부여된 나머지 이름을 모두 출력
	  String[] car3Alias = ctx.getAliases("car3-1");
	  for(String alias : car3Alias){
	  	System.out.println(alias);
	  }
	  
  }
}