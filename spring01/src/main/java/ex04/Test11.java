package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test11 {
	public static void main(String[] args) {
	  ApplicationContext 
  	ctx = new ClassPathXmlApplicationContext("ex04/beans.xml");
	  
	  // ** 선호
	  Object bean = ctx.getBean("car01");
	  System.out.println(bean.getClass().getName());
	  
	  Object bean2 = ctx.getBean("car02");
	  System.out.println(bean2.getClass().getName());
	  System.out.println(bean2);
	  
	  // ** 선호
	  Object bean3 = ctx.getBean("car03");
	  System.out.println(bean3.getClass().getName());
	  System.out.println(bean3);
	  
	  Object bean4 = ctx.getBean("car04");
	  System.out.println(bean4.getClass().getName());
	  System.out.println(bean4);
	  
	  Object bean5 = ctx.getBean("car05");
	  System.out.println(bean5.getClass().getName());
	  System.out.println(bean5);
  }
}