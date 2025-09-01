package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.chap17.board.service.DeleteArticleService;
import mvjsp.chap17.board.service.DeleteRequest;

public class DeleteHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPage = null;
		String id = request.getParameter("articleId");
		String pw = request.getParameter("password");
		DeleteRequest deleteRequest = new DeleteRequest(Integer.parseInt(id),pw);
		try {
			DeleteArticleService.getInstance().deleteArticle(deleteRequest);
			viewPage = "/WEB-INF/view/delete_success.jsp";
		} catch (Exception ex) {
			request.setAttribute("deleteException", ex);
			viewPage = "/WEB-INF/view/delete_error.jsp";
		}
		return viewPage;
	}

}
