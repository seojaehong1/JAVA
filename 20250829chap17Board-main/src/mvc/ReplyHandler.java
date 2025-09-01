package mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvjsp.chap17.board.model.Article;
import mvjsp.chap17.board.service.ReplyArticleService;
import mvjsp.chap17.board.service.ReplyingRequest;


public class ReplyHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewPage = null;
		
		String id = request.getParameter("parentArticleId");
		ReplyingRequest replyingRequest = new ReplyingRequest(Integer.parseInt(id));
		
		try {
			Article postedArticle = ReplyArticleService.getInstance().
					reply(replyingRequest);
			request.setAttribute("postedArticle", postedArticle);
			viewPage = "/reply_success.jsp";
			return viewPage;
		} catch(Exception ex) {
			viewPage = "/reply_error.jsp";
			request.setAttribute("replyException", ex);
			return viewPage;
		}
		
	}

}
