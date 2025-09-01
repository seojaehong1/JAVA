<%@ page contentType="text/html; charset=euc-kr" %>
<%@ page import="mvjsp.chap17.board.service.UpdateArticleService" %>
<%@ page import="mvjsp.chap17.board.model.Article" %>
<% request.setCharacterEncoding("euc-kr"); %>
<jsp:useBean id="updateRequest" 
		class="mvjsp.chap17.board.service.UpdateRequest" />
<jsp:setProperty name="updateRequest" property="*" />
<%
	String viewPage = null;
	try {
		Article article = UpdateArticleService.getInstance().
				update(updateRequest);
		request.setAttribute("updatedArticle", article);
		viewPage = "/updatesuccess.do";
	} catch (Exception ex) {
		request.setAttribute("updateException", ex);
		viewPage = "/updateerror.do";
	}
%>
<jsp:forward page="<%= viewPage %>" />
