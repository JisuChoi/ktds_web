package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;
import kt.c.vo.BoardVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("/board/update.do")
public class BoardUpdateController implements ControllerX {
	@Autowired
	BoardDAO boardDAO;
	
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
