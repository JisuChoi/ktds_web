package kt.c.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import kt.c.control.Controller;

@WebServlet("*.do") // .do로 끝나는 파일은 Front Controller를 거친다
@SuppressWarnings("serial")
public class DispatcherServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
		// 요청이 어떤 서블릿을 원하는지 알아냄
		String servletPath = request.getServletPath();
		response.setContentType("text/html; charset=UTF-8");
		
		try{
			// 스프링 컨테이너가 관리하고 있는 페이지 컨트롤러 꺼내기
			// beanContainer = iocContainer
			ApplicationContext iocContainer = 
					(ApplicationContext)this.getServletContext()
																	.getAttribute("beanContainer");
			Object obj = iocContainer.getBean(servletPath);
			
			if(obj == null || !(obj instanceof Controller)){
				throw new Exception("요구하는 페이지가 없습니다.");
			}
			
			Controller pageController = (Controller)obj;

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
