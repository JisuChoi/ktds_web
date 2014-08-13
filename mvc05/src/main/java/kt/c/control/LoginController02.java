package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping("/auth/login") // 각 요청 핸들러에서 URL 정보를 설정할 수 있다.
public class LoginController02 {
	@Autowired
	LoginDAO loginDAO = new LoginDAO();
	
	// 요청 명령(GET/POST/...)에 따라 호출될 메소드 구분하는 법
	@RequestMapping(value="/auth/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	@RequestMapping(value="/auth/login", method=RequestMethod.POST)
	public String execute(HttpServletRequest request) throws Exception {
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