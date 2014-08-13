package kt.c.control;

import java.util.Map;

import kt.c.dao.BoardDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller("/board/list")
public class BoardListController {
	@Autowired
	BoardDAO boardDAO;
	
	/*
	 *  요청 핸들러 작성 규칙
	 *  예1) ModelAndView 사용
	 *      : 페이지 컨트롤러가 작업한 결과물을 보관하고 뷰 컴포넌트(JSP)의 URL을 저장하는 객체
	 *        프론트 컨트롤러에게 리턴하면, 프론트 컨트롤러가 이객체에서 값을 꺼내 처리
	 *        메소드 앞에 @RequestMapping 붙인다 -> 스프링 프론트 컨트롤러(DispatcherServlet)에게 알려줌

	@RequestMapping
	public ModelAndView execute() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("list", boardDAO.selectAll());
		mv.setViewName("/view/board/list.jsp");
		
		return mv;
	}*/
	
	/*
	 * 요청 핸들러 작성
	 * 예2) 리턴 타입 String
	 *     : 뷰 컴포넌트 URL 리턴(JSP)
	 
	@RequestMapping
	public String execute(Model model) throws Exception {
		model.addAttribute("list", boardDAO.selectAll());
		
		return "/view/board/list.jsp";
	}*/
	
	/*
	 * 요청 핸들러 작성
	 * 예3) 파라미터 Map
	 */
	@RequestMapping
	public String execute(Map<String, Object> model) throws Exception {
		model.put("list", boardDAO.selectAll());
		
		return "/view/board/list.jsp";
	}

}
