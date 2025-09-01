package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ArticleNotFoundException;
import mvjsp.chap17.board.service.ReadArticleService;

public class UpdateErrorHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPage = null;
		try {
			int articleId = Integer.parseInt(request.getParameter("articleId"));
			Article article = ReadArticleService.getInsteance().getArticle(articleId);
			viewPage = "/update_form_view.jsp";
			request.setAttribute("article", article);
		} catch (ArticleNotFoundException ex) {
			viewPage = "/article_not_found.jsp";
		}
		return "/WEB-INF/view/update_form.jsp";
	}

}
