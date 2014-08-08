package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.vo.*;
import kt.c.dao.*;

public class LoginController implements Controller {
	
	LoginDAO loginDAO = new LoginDAO();
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
		
		if(request.getMethod().equals("GET")){
			return "/view/auth/login.jsp";
		} else { // POST
			LoginVO userVO = loginDAO.login(
												new LoginVO()
												.setId(request.getParameter("id"))
												.setPassword(request.getParameter("password")));
			
			if(userVO != null){
				request.getSession().setAttribute("userVO", userVO);
				return "/view/auth/loginProcess.jsp";
			} else {
				return "redirect:login.do";
			}
		}
		
	}
}