package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.chap17.board.model.ArticleListModel;
import mvjsp.chap17.board.service.ListArticleService;


public class DeleteFormHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/WEB-INF/view/delete_form.jsp";
	}

}
