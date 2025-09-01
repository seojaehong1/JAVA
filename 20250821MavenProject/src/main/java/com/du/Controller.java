package com.du;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		HttpSession session = request.getSession();
		
		if(com.equals("/") || com.equals("/main")) {
			String id = (String)session.getAttribute("id");
			if ((String)session.getAttribute("id") != null) {
			view = "loginOk.jsp";
			} else {
			view = "login_main.jsp";
			}
		}else if(com.equals("/login")) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try ( 
		        Connection conn = DriverManager.getConnection(
		        		"jdbc:mysql://localhost:3305/Maven", "root", "1234");
		        Statement stmt = conn.createStatement();
		            
		            // 지정된 아이디와 비밀번호를 가진 레코드가 있는지 쿼리 
		        ResultSet rs = stmt.executeQuery(String.format(         
		                "select * from member where id='%s' and pw='%s'",
		                request.getParameter("id"), request.getParameter("pw")));
		    ) {
		        if (rs.next()) {
		            session.setAttribute("id", rs.getString("id"  ));
		            session.setAttribute("name", rs.getString("name"));
		                
		            view = "loginOk.jsp";
		        } else {
		        	view = "redirect:loginfalse.jsp";
		        }
		        
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		} else if(com.equals("/member_join1")) {
		    request.setCharacterEncoding("utf-8");
		    
		    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try ( 
		        Connection conn = DriverManager.getConnection(
		        		"jdbc:mysql://localhost:3305/Maven", "root", "1234");
		        Statement stmt = conn.createStatement();
		        
		        // 이미 존재하는 아이디인지 체크하는 쿼리 
		        ResultSet rs = stmt.executeQuery(String.format(         
		                "select * from member where id='%s'", 
		                request.getParameter("id")));
		    ) {
		        if (rs.next()) {   
		            view = "member_join_true.jsp";
		       
		        } else {           
		            
		        // 새로운 회원정보를 DB에 추가하는 쿼리
		            stmt.executeUpdate(String.format(
		                    "insert into member values('%s', '%s', '%s')",
		                    request.getParameter("id"  ),
		                    request.getParameter("pw"  ),
		                    request.getParameter("name")));
		            view = "member_join.jsp";
		       
		        }
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		
		} else if(com.equals("/updateread")) {
			request.setCharacterEncoding("utf-8");

		    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try ( 
		        Connection conn = DriverManager.getConnection(
		        		"jdbc:mysql://localhost:3305/Maven", "root", "1234");
		        Statement stmt = conn.createStatement();
		            
		        // 현재 로그인한 사용자 정보를 읽어옴
		        ResultSet rs = stmt.executeQuery(String.format(         
		                    "select * from member where id='%s'", 
		                    (String)session.getAttribute("id")));
		    ) {
		        rs.next();
		        session.setAttribute("id", rs.getString("id"));
		        session.setAttribute("pw", rs.getString("pw"));
		        session.setAttribute("name", rs.getString("name"));
		        view = "member_update_form.jsp";
		    } catch(Exception e) {
		        e.printStackTrace();
		    }
		} else if(com.equals("/update")){
			request.setCharacterEncoding("utf-8");

		    try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    try ( 
		        Connection conn = DriverManager.getConnection(
		        		"jdbc:mysql://localhost:3305/Maven", "root", "1234");
		        Statement stmt = conn.createStatement();
		    ) {
		        // 회원 정보 양식에 입력된 값을 DB에 저장
		        stmt.executeUpdate(String.format(
		                "update member set pw='%s', name='%s' where id='%s'",
		                request.getParameter("pw"  ),
		                request.getParameter("name"),
		                request.getParameter("id"  )));
		        
		        // 사용자 이름을 담은 세션 속성도 업데이트
		        // 아이디는 바뀌지 않지만, 사용자 이름은 바뀔 수 있기 때문임
		        session.setAttribute("name", request.getParameter("name"));
		        view = "member_update.jsp"; 
		    } catch(Exception e) {
		        e.printStackTrace();
		    } 
		} else if(com.equals("/logout")) {
			session.invalidate();
			view = "redirect:login_main.jsp";
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
