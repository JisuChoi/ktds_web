package kt.c.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {

	/* 웹 어플리케이션이 시작되면 호출 */
	@Override
  public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextInitialized()");
		
		// 웹 어플리케이션 시작할 때 서블릿이나 필터 등이 사용할 데이터 준비
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());
		
		try{
			ApplicationContext appCtx = new ClassPathXmlApplicationContext(
					new String[]{
						"kt/c/conf/application-context.xml" // 스프링 설정 파일 위치(classpath 기준)
					});
			ctx.setAttribute("beanContainer", appCtx);
		} catch(Exception e){
			e.printStackTrace();
		}
  }
	
	/* 웹 어플리케이션을 종료하기 전에 호출 */
	@Override
  public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
		// 웹 어플리케이션 종료하기 전에 마무리할 작업 수행
  }
}