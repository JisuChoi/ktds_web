package kt.c.control;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import kt.c.dao.LoginDAO;
import kt.c.vo.LoginVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/auth")
@SessionAttributes("userVO") // Model에 저장된 객체 중에서 어떤 객체를 세션에 보관할 지 설정
public class AuthController {
	@Autowired
	LoginDAO loginDAO = new LoginDAO();
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() throws Exception {
		return "/view/auth/login.jsp";
	}
	
	// @SessionAttributes에 지정된 객체는 Model에 저장하더라도 세션 보관함으로 이동됨
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(LoginVO loginVO, Model model) throws Exception {
		System.out.println("오호라...1");	
		LoginVO userVO = loginDAO.login(loginVO);
			
			if(userVO != null){
				model.addAttribute("userVO", userVO); // userVO라는 이름으로 객체 저장하면 세션에 보관됨
				return "/view/auth/loginProcess.jsp";
			} else {
				return "redirect:login.do";
			}
	}
	
	@RequestMapping("/logout") // method property 지정하지 않으면 모두 허용
	public String execute(SessionStatus status){
		status.setComplete(); // @SessionAttributes에 지정된 객체를 세션에서 제거
		return "redirect:/"; // 스프링에서 redirect URL의 루트(/)는 웹 어플리케이션 루트
	}

}