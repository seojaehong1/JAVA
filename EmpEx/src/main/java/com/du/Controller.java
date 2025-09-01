package com.du;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.du.dao.EmpDao;
import com.du.dto.Emp;

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
		String contextpath = request.getContextPath();
//		System.out.println(url);
//		System.out.println(contextpath);
		String command = uri.substring(contextpath.length());
//		System.out.println(command);
		
		if(command.equals("/") || (command.equals("/dept"))) {
			EmpDao dao = new EmpDao();
			List<Emp> list = dao.selectList(); 
			request.setAttribute("list", list);
			request.setAttribute("isUpdate", "no");
			view = "dept.jsp";
		} else if(command.equals("/b")) {
			view = "redirect:test/b.jsp";
		} else if(command.equals("/insert")) {
			request.setCharacterEncoding("utf-8");
			String isUpdate = request.getParameter("isUpdate");
			int empno = Integer.parseInt(request.getParameter("empno"));
			String ename = request.getParameter("ename");
			String job = request.getParameter("job");
			int mgr = Integer.parseInt(request.getParameter("mgr"));
			String hiredate = request.getParameter("hiredate");
			int sal = Integer.parseInt(request.getParameter("sal"));
			int comm = Integer.parseInt(request.getParameter("comm"));
			int deptno = Integer.parseInt(request.getParameter("deptno"));
			Emp emp = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			EmpDao dao = new EmpDao();
			if(isUpdate.equals("no")) {
				dao.insertOne(emp);
			} else if (isUpdate.equals("yes")){
			dao.updateOne(emp);
			}
			view = "redirect:dept";
		} else if(command.equals("/updateForm")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmpDao dao = new EmpDao();
			Emp emp = dao.selectOne(empno);
			request.setAttribute("dto", emp);
			List<Emp> list = dao.selectList(); 
			request.setAttribute("list", list);
			request.setAttribute("isUpdate", "yes");
			view = "dept.jsp";
		} else if(command.equals("/deleteForm")) {
			int empno = Integer.parseInt(request.getParameter("empno"));
			EmpDao dao = new EmpDao();
			dao.deleteOne(empno);
			view = "redirect:dept";
		} else if(command.equals("/select")) {
			EmpDao dao = new EmpDao();
			List<Emp> list2 = dao.selectList2(); 
			request.setAttribute("list2", list2);
			request.setAttribute("isUpdate", "no");
			view = "dept.jsp";
		}
		
		if(view.startsWith("redirect:")) {
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
