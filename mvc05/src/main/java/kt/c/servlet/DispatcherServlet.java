package kt.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.control.ControllerX;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

//@WebServlet("*.do") // .do로 끝나는 파일은 스프링 프레임워크가 처리
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		// 요청이 어떤 서블릿을 원하는지 알아냄
		String servletPath = request.getServletPath();
		response.setContentType("text/html; charset=UTF-8");
		
		try{
			/*
			 * 스프링 ContextLoaderListener가 IoC 컨테이너를 관리한다.
			 * -> ServletContext에서 IoC를 얻을 수 없다!
			 * -> 따라서 스프링의 도우미 클래스로부터 IoC 컨테이너를 얻어야 한다.
			 */
			
			ApplicationContext iocContainer = 
					WebApplicationContextUtils.getWebApplicationContext(
																					request.getServletContext());
			
			Object obj = iocContainer.getBean(servletPath);
			
			if(obj == null || !(obj instanceof ControllerX)){
				throw new Exception("요구하는 페이지가 없습니다.");
			}
			
			ControllerX pageController = (ControllerX)obj;

			String viewURL = pageController.execute(request, response);
			
			if(viewURL.startsWith("redirect:")){
				response.sendRedirect(viewURL.substring(9));
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(viewURL);
				rd.include(request, response); // 요청 수행 후 다시 돌아오게 하기 위해 include 사용
			}
		} catch(Throwable error){ // Exception의 부모
			
			StringWriter out = new StringWriter(); // 스트링 객체를 출력
			PrintWriter out2 = new PrintWriter(out);
			error.printStackTrace(out2);
			
			request.setAttribute("error", out.toString());
			
			out2.close();
			out.close();
			
			RequestDispatcher rd = request.getRequestDispatcher("/view/error.jsp");
			rd.include(request, response);
		}
	}
}
