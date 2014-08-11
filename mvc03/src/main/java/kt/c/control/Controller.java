package kt.c.control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller  {
	public abstract String execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
}