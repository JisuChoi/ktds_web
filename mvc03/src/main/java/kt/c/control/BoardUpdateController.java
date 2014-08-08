package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;
import kt.c.vo.BoardVO;

public class BoardUpdateController implements Controller {
	
	BoardDAO boardDAO;
	
	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
		
		if(request.getMethod().equals("GET")){
			int no = Integer.parseInt(request.getParameter("no"));
			BoardVO board = boardDAO.selectByNo(no);
			request.setAttribute("board", board);
			
			return "/view/board/updateForm.jsp";			
		} else {
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			
			BoardVO board = new BoardVO();
			board.setNo(no);
			board.setTitle(title);
			board.setContent(content);
			
			boardDAO.update(board);
			
			return "redirect:list.do";
		}
		
	}
}
