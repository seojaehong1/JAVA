<%@page import="study.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<Student> list = new ArrayList<>();
list.add(new Student("홍","서울","1234"));
list.add(new Student("김","서울","1234"));
list.add(new Student("이","서울","1234"));
list.add(new Student("박","서울","1234"));

//for(Student stu : list){
//	out.println(stu+ "<br/>");
//}

request.setAttribute("list", list);
%>
<jsp:forward page="to2.jsp"/>