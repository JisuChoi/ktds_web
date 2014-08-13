package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.BoardDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component("/board/delete.do")
public class BoardDeleteController implements ControllerX {
	@Autowired
	BoardDAO boardDAO;
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
		
		int no = Integer.parseInt(request.getParameter("no"));

		boardDAO.deleteFile(no);
		boardDAO.delete(no);
		
		return "redirect:list.do";
	}
}
