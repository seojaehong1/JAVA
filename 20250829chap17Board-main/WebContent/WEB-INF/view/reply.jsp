<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="mvjsp.chap17.board.service.ReplyArticleService"%>
<%@ page import="mvjsp.chap17.board.model.Article"%>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="replyingRequest" 
		class="mvjsp.chap17.board.service.ReplyingRequest" />
<jsp:setProperty name="replyingRequest" property="*" />
<%
	String viewPage = null;
	try {
		Article postedArticle = ReplyArticleService.getInstance().
				reply(replyingRequest);
		request.setAttribute("postedArticle", postedArticle);
		viewPage = "/replysuccess.do";
	} catch(Exception ex) {
		viewPage = "/replyerror.do";
		request.setAttribute("replyException", ex);
	}
%>
<jsp:forward page="<%= viewPage %>" />
