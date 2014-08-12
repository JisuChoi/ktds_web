package ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
	public static void main(String[] args) {
	  ApplicationContext 
	  	ctx = new ClassPathXmlApplicationContext("ex01/beans.xml");
	  
	  /*
	   * getBean(ID 또는 별명): 컨테이너에서 해당 ID나 별명을 갖는 객체를 찾아서 리턴
	   */
	  Car p = (Car)ctx.getBean("car01");
	  
//	  Car p2 = (Car)ctx.getBean("car02"); // 존재하지 않는 bean이기 때문에 예외 발생
  }
}
