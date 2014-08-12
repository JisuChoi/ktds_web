package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test12 {
	public static void main(String[] args) {
	  ApplicationContext 
  	ctx = new ClassPathXmlApplicationContext("ex05/beans.xml");

	  // @Component의 value 값을 설정하지 않으면,
	  // 인스턴스는 클래스 이름(첫 글자 소문자)으로 보관
	  Car car1 = (Car)ctx.getBean("car");
	  System.out.println(car1);
	  
	  Engine engine = (Engine)ctx.getBean("engine01");
	  System.out.println(engine);
  }
}