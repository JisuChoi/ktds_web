package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kt.c.dao.*;

public class BoardDetailController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
		
		String type = request.getParameter("type");
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = new BoardDAO();
		if (type != null && type.equals("list")) {
			dao.updateViewCnt(no);
		}
		request.setAttribute("board", dao.selectByNo(no));
		request.setAttribute("fileList", dao.selectFileBoard(no));
		
		return "/view/board/detail.jsp";		
	}
}
