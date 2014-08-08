package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;

public class BoardListController implements Controller {
	
	BoardDAO boardDAO;
	
	// execute보다 먼저 호출되어야함!
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
	    throws Exception {
		
		req.setAttribute("list", boardDAO.selectAll());
		
		return "/view/board/list.jsp";
	}
}
