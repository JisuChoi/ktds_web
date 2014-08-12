package ex07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test15 {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ex07/beans.xml");

		// 인스턴스 생성 순서 주목하라!
		Car car1 = (Car)ctx.getBean("ex07.Car");
		System.out.println(car1);
		
	}
}