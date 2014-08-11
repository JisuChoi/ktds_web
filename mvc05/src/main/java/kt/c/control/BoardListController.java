package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("/board/list.do")
public class BoardListController implements Controller {
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
	    throws Exception {
		
		req.setAttribute("list", boardDAO.selectAll());
		
		return "/view/board/list.jsp";
	}
}
