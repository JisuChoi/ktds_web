package kt.c.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kt.c.control.BoardDeleteController;
import kt.c.control.BoardDetailController;
import kt.c.control.BoardListController;
import kt.c.control.BoardUpdateController;
import kt.c.control.BoardWriteController;
import kt.c.control.LoginController;
import kt.c.control.LogoutController;

public class ContextLoaderListener implements ServletContextListener {

	/* 웹 어플리케이션이 시작되면 호출 */
	@Override
  public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextInitialized()");
		
		// 웹 어플리케이션 시작할 때 서블릿이나 필터 등이 사용할 데이터 준비
		ServletContext ctx = sce.getServletContext();
		ctx.setAttribute("contextRoot", ctx.getContextPath());
		ctx.setAttribute("/board/list.do", new BoardListController());
		ctx.setAttribute("/auth/login.do", new LoginController());
		ctx.setAttribute("/auth/logout.do", new LogoutController());
		ctx.setAttribute("/board/detail.do", new BoardDetailController());
		ctx.setAttribute("/board/delete.do", new BoardDeleteController());
		ctx.setAttribute("/board/write.do", new BoardWriteController());
		ctx.setAttribute("/board/update.do", new BoardUpdateController());
  }

	/* 웹 어플리케이션을 종료하기 전에 호출 */
	@Override
  public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextLoaderListener.contextDestroyed()");
		// 웹 어플리케이션 종료하기 전에 마무리할 작업 수행
  }
}