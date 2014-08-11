package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component("/auth/logout.do")
public class LogoutController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
		
		request.getSession().invalidate();
		return "/view/auth/logout.jsp"; // "/mvc01" 의미
	}
}