package kt.c.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationInitListener implements ServletContextListener {

	@Override
  public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ApplicationInitListener.contextInitialized()");
		
		// JSP에서 사용할 contextRoot 정보를 저장
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());
  }
	
	@Override
  public void contextDestroyed(ServletContextEvent sce) {
  }
}