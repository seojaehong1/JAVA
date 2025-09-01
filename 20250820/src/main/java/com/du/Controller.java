package com.du;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.du.dao.Empdao;
import com.du.dto.EmpDept;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/")|| com.equals("/main")) {
			
			String userId = null;
			
		    Cookie[] cookies = request.getCookies();           
		    if (cookies != null) {
		        for(Cookie cookie : cookies) {           
		            if (cookie.getName().equals("userId")) { // userId 쿠키의 값을
		                userId = cookie.getValue();          // 변수 userId에 넣음
		                break;
		            }
		        }
		    }
		   
		    
		    if (userId != null) {  
		    	request.setAttribute("userId", userId);
		    	view = "loginok.jsp";
		    } else {                       // 로그인되지 않은 상태일 때의 출력
		    	view = "redirect:loginForm.jsp";
		    }
		}else if(com.equals("/login")) {
			String id = request.getParameter("id");
		    String pw = request.getParameter("pw");

		    if (id.equals("admin") && pw.equals("1234")) {
		        Cookie cookie = new Cookie("userId", id);
		        cookie.setMaxAge(-1);         // 웹 브라우저가 닫힐 때 쿠키 만료됨
		        response.addCookie(cookie);
		        
		        
		        view = "loginok.jsp";
		    } else {
		    	view = "redirect:loginfail.jsp";
		    }
		}else if(com.equals("/logout")) {
			Cookie cookie = new Cookie("userId", null);
		    cookie.setMaxAge(0);           
		    response.addCookie(cookie);
		        
		    response.sendRedirect("redirect:loginForm.jsp");   // 로그인 메인 화면으로 돌아감
			
		}
		if (view.startsWith("redirect:")) {
			response.sendRedirect(view.substring(9));
		} else {
			request.getRequestDispatcher(view).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
