package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.chap17.board.service.DeleteArticleService;
import mvjsp.chap17.board.service.DeleteRequest;

public class UpdateFormHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "/WEB-INF/view/update_error.jsp";
	}

}
