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
public class AuthController02 {
	@Autowired
	LoginDAO loginDAO = new LoginDAO();
	
	/*
	 * servletContext 객체는 파라미터로 받을 수 없음
	 * 대신, 인스턴스 변수를 통해 주입 받을 수 있다.
	 */
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	//  요청파라미터이름과 변수명이 같다면 annotation 생략 가능
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
			/*@RequestParam("id")*/ String id, // 요청 파라미터 id를 받기 위한 변수
			/*@RequestParam("password")*/ String password, // 요청 파라미터 password를 받기 위한 변수
			HttpSession session) throws Exception {
		
			LoginVO userVO = loginDAO.login(new LoginVO().setId(id).setPassword(password));
			
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