<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="mvjsp.chap17.board.service.ReadArticleService" %>
<%@ page import="mvjsp.chap17.board.model.Article" %>
<%@ page import="mvjsp.chap17.board.service.ArticleNotFoundException" %>
<%
	String viewPage = null;
	try {
		int articleId = Integer.parseInt(request.getParameter("articleId"));
		Article article = ReadArticleService.getInsteance().getArticle(articleId);
		viewPage = "/updateformview.do";
		request.setAttribute("article", article);
	} catch (ArticleNotFoundException ex) {
		viewPage = "/articlenotfound.do";
	}
%>
<jsp:forward page="<%= viewPage %>" />
