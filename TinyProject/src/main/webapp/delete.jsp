<%@page import="dto.TinyDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.TinyDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String num = request.getParameter("num");
TinyDAO dao = new TinyDAO();
dao.deleteOne(Integer.parseInt(num));
response.sendRedirect("list.jsp");
%>