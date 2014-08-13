package kt.c.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//클래스 선언부에서 기본 URL을 지정하고, 요청 핸들러(메소드)에서는 나머지 URL 지정
//@Controller
@RequestMapping("/auth")
public class AuthController03 {
	@Autowired
	LoginDAO loginDAO = new LoginDAO();
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	// 요청 파라미터의 값을 VO 객체에 바로 받는다.
	// 요청 파라미터의 이름과 객체의 프로퍼티 이름이 같아야한다.
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVO, HttpSession session) throws Exception {
		System.out.println("오호라...1");	
		LoginVO userVO = loginDAO.login(loginVO);
			
			if(userVO != null){
				session.setAttribute("userVO", userVO);
				return "/view/auth/loginProcess.jsp";
			} else {
				return "redirect:login.do";
			}
	}
	
	@RequestMapping(value="/logout") // method property 지정하지 않으면 모두 허용
	public String execute(HttpSession session){
		session.invalidate();
		return "redirect:/"; // 스프링에서 redirect URL의 루트(/)는 웹 어플리케이션 루트
	}

}