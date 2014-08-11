package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;

public class BoardDeleteController implements Controller {
	
	BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));

		boardDAO.deleteFile(no);
		boardDAO.delete(no);
		
		return "redirect:list.do";
	}
}
