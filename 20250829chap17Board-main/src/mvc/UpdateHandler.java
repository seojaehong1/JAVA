package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.UpdateArticleService;
import mvjsp.chap17.board.service.UpdateRequest;

public class UpdateHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPage = null;
		
		
		
		String articleId = request.getParameter("articleId");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String password = request.getParameter("password");
		UpdateRequest updateRequest = new UpdateRequest(Integer.parseInt(articleId),title,content,password);
		try {
			Article article = UpdateArticleService.getInstance().
					update(updateRequest);
			request.setAttribute("updatedArticle", article);
			viewPage = "/update_success.jsp";
		} catch (Exception ex) {
			request.setAttribute("updateException", ex);
			viewPage = "/update_error.jsp";
		}
		return "/WEB-INF/view/update_form.jsp";
	}

}
