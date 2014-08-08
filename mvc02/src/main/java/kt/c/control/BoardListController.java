package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;

public class BoardListController implements Controller {
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp)
	    throws Exception {
		
		BoardDAO dao = new BoardDAO();
		req.setAttribute("list", dao.selectAll());
		
		return "/view/board/list.jsp";
	}
}
